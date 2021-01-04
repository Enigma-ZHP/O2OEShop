$(document).ready(function(){

	$("div#menuIndex a").on("click",function(event){
		 var href=$(this).attr("href");
		 $("div#main_embed").load(href);
		 
		 event.preventDefault();
	});
	
	
	
});