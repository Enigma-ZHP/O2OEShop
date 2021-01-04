$(document).ready(function(){
	var goodid;
	
	var showphoto=function(id){
		var url="../Good/getPhoto.do?id="+id;
		$("img#img_zoom").attr("src",url);
		$.ajax({
			type:"post",
			url:"../Good/goodbyid.do?gid="+id,
			success:function(result){
				goodid=result.gid;
				$("div#goodname").html("<a>"+result.gname+"</a>");
				$("span#goodprice").html("<ins>"+result.gprice+"</ins>")
			}
		})
		
	}
	$("a#addWish").on("click",function(){
		var uid=$.cookie("userid");
		alert("用户id:"+$.cookie("userid")+"商品id:"+goodid);
		$.ajax({
			url:"../User/wish.do?uid="+uid+"&gid="+goodid,
			type:"post",
			success:function(){
				alert("添加购物车成功");
			},
			error:function(){
				alert("添加购物车失败");
			}
		});
	});
	showphoto($.cookie("goodid"));

});