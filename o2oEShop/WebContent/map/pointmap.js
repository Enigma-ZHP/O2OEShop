$(document).ready(function(){
	var city;
	var localx;
	var localy;
	function getIP(){
		$.ajax({
			url:"https://api.map.baidu.com/location/ip?ak=xepkGUtLdju9XwYxHgt1fUp6l7fAeWf2&coor=bd09ll",
			dataType:"jsonp",
			success:function(results){
				console.log(results);
				city=results.content.address_detail.city;
				localx=results.content.point.x;
				localy=results.content.point.y;
				getlocation(city,$.cookie("categoryid"));
				//alert(localx+" "+localy);
			},
			error:function(){
				alert("errror");
			}
		});
		
	};
	function getlocation(local,cid){
		alert("local:"+local+" cid:"+cid);
		var category;
		var URL;
		if(cid==1){
			category= "购物&tag=家电数码&";
		}else if(cid==2){
			category= "购物&tag=百货商场&";
		}else if(cid==3){
			category= "购物&tag=市场&";
		}else{
			category= "购物&tag=其他&";
		}
		URL="http://api.map.baidu.com/place/v2/search?query="+category+"region="+local+"&output=json&ak=xepkGUtLdju9XwYxHgt1fUp6l7fAeWf2";
		console.log(URL);
		console.log(category);
		$.ajax({
			type:"post",
			url:URL,
			dataType:"jsonp",
			success:function(result){
				console.log(result);
				var map = new BMap.Map("allmap");
				map.centerAndZoom(new BMap.Point(result.results[1].location.lng,result.results[1].location.lat), 15);
				var opts = {
						width : 250,     // 信息窗口宽度
						height: 80,     // 信息窗口高度
						title : "信息窗口" , // 信息窗口标题
						enableMessage:true//设置允许信息窗发送短息
					   };
				map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
				alert(result.results.length);
				for(var i=0;i<result.results.length;i++){
					var lng=result.results[i].location.lng;
					var lat=result.results[i].location.lat;
					var content=result.results[i].address;
					var marker = new BMap.Marker(new BMap.Point(lng,lat));  // 创建标注
					map.addOverlay(marker);
					addClickHandler(content,marker);
				}
				function addClickHandler(content,marker){
					marker.addEventListener("click",function(e){
						openInfo(content,e)}
					);
				}
				function openInfo(content,e){
					var p = e.target;
					var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
					var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象 
					map.openInfoWindow(infoWindow,point); //开启信息窗口
				}
			}
		});
	};

	
	getIP();
});