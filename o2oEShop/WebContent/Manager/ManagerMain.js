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
		alert("user");
		getUserListAndShow();
	});
	$("a#viewShopInfor").on("click",function(){
		alert("shop");
		getShopListAndShow();
		
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
			alert(gid);
			$("div#main_embed").load("o2oGoodUpdate.html");
			event.preventDefault();
			$.ajax({
				url:"../Good/goodbyid.do?gid="+gid,
				type:"post",
				success:function(result){
					console.log(result);
					$("input#shopid").attr({placeholder:result.sid});
					$("input#goodid").attr({placeholder:result.gid});
					$("input#goodname").attr({placeholder:result.gname});
					$("input#goodprice").attr({placeholder:result.gprice});
					$("input#gooddate").attr({placeholder:result.gdate});
				},
				error:function(){
					alert("no");
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
	getShopListAndShow=function(){
		updateShopinfor=function(){
			$("div#main_embed").load("viewShopInfor.html");
			event.preventDefault();
		};
		deleteShopinfor=function(id){
			$.ajax({
				type:"post",
				url:"../Shop/deleteshop.do?id="+id.toString(),
				success:function(){alert("delete ok")},
				error:function(){alert("errror")}
			})
		};
		$.ajax({
			type:"post",
			url:"../Shop/selectAllShop.do",
			success:function(List){
				$("div#goodlist").html("");
				var Line="<table class='table'><thead><tr><th>#</th><th>name</th><th></th><th>order</th></tr></thead><tbody>";
				for(var i=0;i<List.length;i++){
					Line+="<tr><td>"+List[i].sid+"</td><td>"+List[i].sname+"</td><td></td>";
					Line+="<td><button onclick='updateShopinfor()' type='button' class='btn btn-primary'>Update</button>";
					Line+="<button onclick='deleteShopinfor("+List[i].sid+")' type='button' class='btn btn-danger'>Delete</button></td></tr>";
				}
				Line+="</tbody></table>";
				$("div#goodlist").append(Line);
			},
			error:function(){
				alert("无法读取");
			}
		});
	}
	function getUserListAndShow(){
		updateUserinfor=function(){
			$("div#main_embed").load("viewUserInfor.html");
			event.preventDefault();
			
		};
		deleteUserinfor=function(id){
			$.ajax({
				type:"post",
				url:"../User/deleteUser.do?id="+id.toString(),
				success:function(){alert("delete ok")},
				error:function(){alert("errror")}
			})
		};
		wishlist=function(id){
			$.cookie("userid",id);
			window.location.replace("./wishList.html");
		};
		$.ajax({
			type:"post",
			url:"../User/selectAllUser.do",
			success:function(List){
				$("div#goodlist").html("");
				var Line="<table class='table'><thead><tr><th>#</th><th>name</th><th></th><th>order</th></tr></thead><tbody>";
				for(var i=0;i<List.length;i++){
					Line+="<tr><td>"+List[i].uid+"</td><td>"+List[i].uname+"</td><td></td>";
					Line+="<td><button onclick='updateUserinfor()' type='button' class='btn btn-primary'>Update</button>";
					Line+="<button onclick='wishlist("+List[i].uid+")' type='button' class='btn btn-info'>wish</button>";
					Line+="<button onclick='deleteUserinfor("+List[i].uid+")' type='button' class='btn btn-danger'>Delete</button></td></tr>";
				}
				Line+="</tbody></table>";
				$("div#goodlist").append(Line);
			},
			error:function(){
				alert("无法读取");
			}
		});
	}
	getListAndShow();
});