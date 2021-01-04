$(document).ready(function(){
	var URL="../Good/goodlist.do";
	var categoryid=0;
	$("a#selectgood").on("click",function(){
		getListAndShow();
	});
	$("a#search_good").on("click",function(event){
		categoryid=$("select#goodcategoryid").val();
		alert(categoryid);
		console.log(categoryid);
		getListAndShow();
	});
	$("a#viewUserInfor").on("click",function(){
		$.ajax({
			type:"post",
			url:"../User/userinfor.do?uid="+$.cookie("userid"),
			success:function(result){
				$("h5#useruid").append("<p> "+$.cookie("userid")+"</p>");
				$("input#userid").attr({placeholder:$.cookie("userid")});
				$("input#username").attr({placeholder:result.uname});
				$("input#userage").attr({placeholder:result.uage});
				$("input#userpassword").attr({placeholder:result.upassword});
				//$("ul#shopcategory li input").attr({value:result.cid})
				//var num=result.shopAndcategoryid;
				//$("input[name='shopAndcategoryid'][value="+num+"]").attr("checked",true); 
			},
			error:function(){
				alert("商家信息取出失败");
			}
			
		});
	});
	function getListAndShow(){
		var userid=$.cookie("userid");
		if(categoryid==0){
			URL="../Good/goodlist.do";
		}else if(categoryid==1){
			URL="../Good/goodlistbycid.do?id=1";
		}else if(categoryid==2){
			URL="../Good/goodlistbycid.do?id=2";
		}else if(categoryid==3){
			URL="../Good/goodlistbycid.do?id=3";
		}else{
			URL="../Good/goodlistbycid.do?id=4";
		}
		todetail=function(gid,cid){
			$.cookie("goodid",gid,{path:"/"});
			$.cookie("categoryid",cid,{path:"/"});
			alert($.cookie("goodid")+" success "+$.cookie("categoryid"));
			window.location.replace("../map/detail.html");
		};
		addwish=function(gid,uid){
			console.log(gid+" "+uid);
			$.ajax({
				type:"post",
				url:"../User/wish.do?uid="+uid+"&gid="+gid,
				success:function(){
					alert("添加购物车成功");
				},
				error:function(){
					alert("添加购物车失败");
				}
			});
		};
		$.ajax({
			type:"post",
			url:URL,
			//date:{cid:"categoryid"},
			success:function(List){
				$("div#goodlist").html("");
				for(var i=0;i<List.length;i++){
					//var line="<tr id='"+list[i].no+"'><td>"+list[i].no+"</td><td>"+list[i].code+"</td><td>"+list[i].name+"</td></tr>";
					
					var Line="<div class='product-items'><div class='product-image'>";
	                Line+="<a href='#' onclick='todetail("+List[i].gid+","+List[i].cid+")'><img src='../Good/getPhoto.do?id="+List[i].gid+"' alt='lost photo'/></a>";
	                //Line+="<span class='onsale'>-50%</span>";
	                Line+="<a href='#' class='quick-view'>Quick View</a></div>";
	                Line+="<div class='product-info'><div class='product-name'><a href='#'>"+List[i].gid+": "+List[i].gname+"</a></div>";
	                Line+="<span class='star-rating'><i class='fa fa-star' aria-hidden='true'></i><i class='fa fa-star' aria-hidden='true'></i><i class='fa fa-star' aria-hidden='true'></i><i class='fa fa-star' aria-hidden='true'></i><i class='fa fa-star' aria-hidden='true'></i><span class='review'>5 Review(s)</span></span>";
	                Line+="<div class='product-infomation'></div></div>";
	                Line+="<div class='product-info-price'><div class='product-info-stock-sku'>";
	                Line+="<div class='stock available'><span class='label-stock'>Avability:</span> In Stock</div></div>";
	                Line+="<span class='price'><ins>"+List[i].gprice+"</ins></span>";
	                Line+="<div class='single-add-to-cart'>";
	                Line+="<a href='#' onclick='addwish("+List[i].gid+","+userid+")' class='btn-add-to-cart'>Add to cart</a>";
	              //  Line+="<a href='#' onclick='deletegood("+List[i].gid+")' class='btn-add-to-cart'></i>Delete</a>"
	                Line+="</div>";
	                Line+="</div></div>";
	                $("div#goodlist").append(Line);
				}
			},
			error:function(){
				console.log(URL);
			}
		});
    }
	getListAndShow();
});