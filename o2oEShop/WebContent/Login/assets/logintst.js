$(document).ready(function(){
    var shopid;
  
    console.log(shopinfor);
    $("input#addsss").on("click",function(){
    	$.ajax({
    		type:"post",
    		url:"../Shop/selectMaxsid.do",
    		success:function(result){
    			alert("您的商铺账号为:s"+result);
    		}
    	});
    	
    	//alert("您的商铺账号为:s"+$.cookie("shopid"));
    	//window.location.replace("./userLogin.html");
    });
    $("input#logintst").on("click",function(){
    	alert("您的用户账号为:u"+$.cookie("userid"));
    });
    
    
    getShopCookie=function(shopid){
    	$.ajax({
    		type:"post",
    		url:"../Shop/getCookie.do?shopid="+shopid,
    		success:function(result){
    			alert("您的商铺账号为:s"+result);
    		}
    	});
    }
});