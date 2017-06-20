$(document).ready(function(){
    $(".product").click(function () {
        var id =$(this).attr("id");
       window.location="product_detail.html?id="+id+"";
    });
    
   
});