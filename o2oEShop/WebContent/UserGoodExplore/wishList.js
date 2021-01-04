$(document).ready(function(){
	
	function getWishListAndShow(){
		var URL="../User/wishList.do?uid="+$.cookie("userid");
		
		deletegood=function(id){
			$.ajax({
				type:"post",
				url:"../User/wishdelete.do?id="+id.toString(),
				success:function(){alert("delete ok")},
				error:function(){alert("errror")}
			})
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
				$("tbody#wish_embed").html("");
				for(var i=0;i<List.length;i++){
					var Line="<tr><td class='tb-image'><a href='#' class='item-photo'><img src='../Good/getPhoto.do?id="+List[i].gid+"' alt='cart'></a></td>";
	                Line+="<td class='tb-product'><div class='product-name'><a href='#''>"+List[i].gname+"</a></div></td>";
	                Line+="<td class='tb-price'><span class='price'>"+List[i].gprice+"</span></td>";
	                Line+="<td class='tb-add'><button type='submit'><span>Buy</span></button></td>";
	                Line+="<td class='tb-remove'><a href='#' onclick='deletegood("+List[i].id+")' class='action-remove'><span><i class='flaticon-close' aria-hidden='true'></i></span></a></td></tr>";
	                $("tbody#wish_embed").append(Line);
				}
			},
			error:function(){
				console.log(URL);
			}
		});
    }
	getWishListAndShow();
});