$(document).ready(function(){
	
	//取得列表并显示
	function getListAndShow(){
		$.getJSON("../Shop/selectAll.do",function(List){
			$("div#good_list").html("");
			for(var i=0;i<List.length;i++){
				//var line="<tr id='"+list[i].no+"'><td>"+list[i].no+"</td><td>"+list[i].code+"</td><td>"+list[i].name+"</td></tr>";
                var Line="<div class='product-items'><div class='product-image'>";
                Line+="<a href='#'><img src='assets/images/product/p1.jpg' alt='p1'></a>";
                Line+="<span class='onsale'>-50%</span>";
                Line+="<a href='#' class='quick-view'>Quick View</a></div>";
                Line+="<div class='product-info'><div class='product-name'><a href='#'>"+List[i].sname+"</a></div>";
                Line+="<span class='star-rating'><i class='fa fa-star' aria-hidden='true'></i><i class='fa fa-star' aria-hidden='true'></i><i class='fa fa-star' aria-hidden='true'></i><i class='fa fa-star' aria-hidden='true'></i><i class='fa fa-star' aria-hidden='true'></i><span class='review'>5 Review(s)</span></span>";
                Line+="<div class='product-infomation'></div></div>";
                Line+="<div class='product-info-price'><div class='product-info-stock-sku'>";
                Line+="<div class='stock available'><span class='label-stock'>Avability:</span> In Stock</div></div>";
                Line+="<span class='price'><ins>"+"100"+"</ins></span>";
                Line+="</div></div>";
                $("div#good_list").append(Line);
			}
			
			
		});
    }
	getListAndShow();
});