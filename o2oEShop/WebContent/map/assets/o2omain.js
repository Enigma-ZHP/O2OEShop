$(document).ready(function(){
    $("a#userlogin").on("click",function(event){
        $("div#main_embed").load("o2oLogin.html",function(){
            alert("embed success");
        });
    });
});