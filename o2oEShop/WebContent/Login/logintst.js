$(document).ready(function(){
    
    $("input#addsss").on("click",function(){
    	var sname = $('[name=sname]').val();
    	var spassword = $('[name=spassword]').val();
    	var cid=$('input[name="cid"]:checked').val();
    	var shopcategoryid=parseInt(cid);
    	//var cid = $('[name=cid]').val();
    	console.log(sname+" "+spassword+" "+cid+" ");
    	if(sname!=""&&spassword!=""&&cid!=""){
    		//alert("okok");
    		$.ajax({
    			url:"../Shop/shoplogin.do",
    			type:"post",
    			data:{"sname":sname,"spassword":spassword,"cid":shopcategoryid},
    			success:function(){
    				alert($.cookie("shopid"));
    				window.location.replace("../Good/main.html");
    			},
    			error:function(){
    				alert("nono");
    			}
    		});
    	}else{
    		alert("请正确填写信息");
    	}
    	//alert("您的商铺账号为:s"+$.cookie("shopid"));
    	//window.location.replace("./userLogin.html");
    });
    $("input#logintst").on("click",function(){
    	var uname = $('[name=uname]').val();
    	var uage = $('[name=uage]').val();
    	var upassword = $('[name=upassword]').val();
    	console.log(uname+" "+uage+" "+upassword);
    	if(uname!=""&&uage!=""&&upassword!=""){
    		$.ajax({
    			url:"../User/login.do",
    			type:"post",
    			data:{"uname":uname,"uage":parseInt(uage),"upassword":upassword},
    			success:function(){
    				alert($.cookie("userid"));
    				window.location.replace("../UserGoodExplore/GoodExplore.html")
    			},
    			error:function(){
    				alert("注册失败");
    			}
    		});
    	}else{
    		alert("请正确填写信息");
    	}
    	
    	//alert("您的用户账号为:u"+$.cookie("userid"));
    });
});