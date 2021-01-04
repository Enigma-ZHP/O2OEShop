$(document).ready(function(){
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
	$("a#viewShopInfor").on("click",function(){
		$.ajax({
			type:"post",
			url:"../Shop/shopinfor.do?sid="+$.cookie("shopid"),
			success:function(result){
				$("h5#shopsid").append("<p> "+$.cookie("shopid")+"</p>");
				$("input#shopid").attr({placeholder:$.cookie("shopid")});
				$("input#shopname").attr({placeholder:result.sname});
				$("input#shoppassword").attr({placeholder:result.spassword});
				//$("ul#shopcategory li input").attr({value:result.cid})
				//var num=result.shopAndcategoryid;
				//$("input[name='shopAndcategoryid'][value="+num+"]").attr("checked",true); 
			},
			error:function(){
				alert("商家信息取出失败");
			}
			
		});
	});
	
	//取得列表并显示
	function getListAndShow(){
		var URL="../Good/goodlistbysid.do?sid="+$.cookie("shopid");
		
		deletegood=function(id){
			$.ajax({
				type:"post",
				url:"../Good/deletegood.do?id="+id.toString(),
				success:function(){alert("delete ok")},
				error:function(){alert("errror")}
			})
		};
		updategood=function(event,gid){
			
			//var href=$(this).attr("href");
			//alert("soso");
			$("div#main_embed").load("o2oGoodUpdate.html");
			event.preventDefault();
			$.cookie("goodid",gid,{path:"/"});
			var cookiegid=$.cookie("goodid");
			alert("商品id"+$.cookie("goodid"));
			$.ajax({
				url:"../Good/goodbyid.do?gid="+cookiegid,
				type:"post",
				success:function(result){
					console.log(result);
					$("input#goodid").attr({placeholder:cookiegid});
					$("input#goodname").attr({placeholder:result.gname});
					$("input#gooddate").attr({placeholder:result.gdate});
					$("input#goodprice").attr({placeholder:result.gprice});
				},
				error:function(){
					alert("出错");
				}
			});
			
		};
		todetail=function(gid,cid){
			$.cookie("goodid",gid,{path:"/"});
			$.cookie("categoryid",cid,{path:"/"});
			alert($.cookie("goodid")+" success "+$.cookie("categoryid"));
			window.location.replace("../map/detail.html");
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
	                Line+="<a href='#' onclick='updategood(event,"+List[i].gid+")' class='btn-add-to-cart'>Update</a>";
	                Line+="<a href='#' onclick='deletegood("+List[i].gid+")' class='btn-add-to-cart'></i>Delete</a>"
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