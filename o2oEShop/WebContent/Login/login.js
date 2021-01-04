$(document).ready(function(){
	
	var userid;
	var shopid;
	$("input#UserLogin").on("click",function(){
		var userid=$("input#Userid").val();
		var userpassword=$("input#UserPassword").val();
		if(!userid||!userpassword){
			alert("userid cant be empty");
			return ;
		}
		var sign=userid.substring(0,1);
		var realuserid=userid.substring(1);
		
		
		if(sign=="s"){
			alert("您是商家");
			$.ajax({
				type:"post",
				url:"../Shop/shopregister.do?id="+realuserid+"&password="+userpassword,
				dataType:"json",
				success:function(result){
					//$.cookie("shopid",result.sid)
					if(result!=0){
						//alert("登录成功");
						$.cookie("shopid",result,{path:"/"});
						alert($.cookie("shopid")+" login success");
						window.location.replace("../Good/main.html");
					}else{
						alert("用户名或密码不正确");
						return ;
					}
				},
				error:function(){
					alert("用户名或密码不正确");
				}
			})
		}else if(sign=="u"){
			alert("您是客户");
			$.ajax({
				type:"post",
				url:"../User/userregister.do?id="+realuserid+"&password="+userpassword,
				dataType:"json",
				success:function(results){
					if(results!=0){
						//alert("登录成功");
						$.cookie("userid",results,{path:"/"});
						alert($.cookie("userid")+" login success");
						window.location.replace("../UserGoodExplore/GoodExplore.html");
					}else{
						alert("用户名或密码不正确");
						return ;
					}
				},
				error:function(){
					alert("用户名或密码不正确");
				}
			});
			
		}else if(userid=="manager"&&userpassword=="12345"){
			window.location.replace("../Manager/ManagerMain.html");
		}else{
			alert("标识符非法");
		}
		
	})
	
	

});