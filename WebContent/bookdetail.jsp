<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Book Management System</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
		
		<!-- bootstrap -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">      
		<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">		
		<link href="themes/css/bootstrappage.css" rel="stylesheet"/>
		<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
		
		<!-- global styles -->
		<link href="themes/css/main.css" rel="stylesheet"/>
		<link href="themes/css/jquery.fancybox.css" rel="stylesheet"/>
				
		<!-- scripts -->
		<script src="themes/js/jquery-1.7.2.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>				
		<script src="themes/js/superfish.js"></script>	
		<script src="themes/js/jquery.scrolltotop.js"></script>
		<script src="themes/js/jquery.fancybox.js"></script>
			<script type="text/javascript" src="js/index.js"></script>
			<script src="js/myfx.js"></script>
		<!--[if lt IE 9]>			
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->
		
		<script>
		

	    $(document).ready(function () {

    	var cat_id =$(".catd").attr("id");
	  
	        $.ajax({
	            type: 'POST',
            url:'bookdetailAction!relByCat',
	            data:'cat_id='+cat_id,
	            success: function(data){
	           
	               $(".rltb").html(data);
	               $(".rltb").children().filter(".item").eq(1).addClass("active");
	            }
	        });
	        
	        
	   
	    });
	    
	  
		</script>
	</head>
    <body>		
		<div id="top-bar" class="container">
			<div class="row">
				<div class="search">
					
				</div>
				<div class="span8 menu-p">
					<div class="account pull-right">
						<ul class="user-menu">				
							<li><a href="bookAction">Home</a></li>
							<li><a href="bookAction!toBooks">Books</a></li>
							<li><a href="borrowAction!myHistory">My History</a></li>
							<li><a href="register.html">Login</a></li>		
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="wrapper" class="container">

			<section class="header_text sub">
			<img class="pageBanner" src="themes/images/pageBanner.png" alt="New products" >
				<h4><span>Product Detail</span></h4>
			</section>
			<section class="main-content">				
							<div class="row" style="width:100%;">						
					<div class="span9" style="text-align:center;width:80%;margin-left:13%;">	
						<div class="row">
						    
							<div class="span4">
								<a href="${dbook.cover }" class="thumbnail" data-fancybox-group="group1" title="${dbook.bookname }"><img alt="" src="${dbook.cover }"></a>												

							</div>
					                <input type="hidden" class="catd" id="${dbook.category }">
							<div class="span5" >
								<address>
									<strong>Book Name:</strong> <span>${dbook.bookname }</span><br>
									<strong>Author:</strong> <span>${dbook.author }</span><br>
									<strong>Press:</strong> <span>${dbook.press }</span><br>
									<strong>Presstime:</strong> <span><s:date name="dbook.presstime" format="yyy-MM"/></span><br>
									<strong>ISBN:</strong> <span>${dbook.isbn }</span><br>
									<strong>In-Stock:</strong> <span>${dbook.inStock}</span><br>
                                    
                                  

								</address>									

							</div>
							<div class="span5">
							    <a href="borrowBookAction?bookId=${dbook.id }">
								<button class="btn btn-inverse" type="submit">Borrow</button></a>							
							</div>							
						</div>
						<div class="row" style="margin-top: 30px;">
							<div class="span9">
								<ul class="nav nav-tabs" id="myTab">
									<li class="active a" style="border:2px solid orange;margin-right:15px;width:100px;text-align:center;">Description</li>
									<li class="b" style="border:2px solid orange;margin-right:15px;width:150px;text-align:center;">Additional Information</li>
								</ul>							 
								<div class="tab-content">
									<div class="tab-pane active" id="home">${dbook.introduction }</div>
									<div class="tab-pane" id="profile">
										<table class="table table-striped shop_attributes">	
											<tbody>
												<tr class="">
													<th>Borrowcount</th>
													<td>${dbook.borrowcounts }</td>
												</tr>		
												
												<tr class="alt">
													<th>Category</th>
													<td>${bnCategory.name }</td>
												</tr>
											
											</tbody>
										</table>
									</div>
								</div>							
							</div>						
							<!--  <div class="span9">	
								<br>
								<h4 class="title">
									<span class="pull-left"><span class="text"><strong>Related</strong> Books</span></span>
									<span class="pull-right">
										<a class="left button lprev" href="#myCarousel-1" data-slide="prev"></a><a class="right button rnext"  href="#myCarousel-1" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel-1" class="carousel slide">
									<div class="carousel-inner bd-carousel rltb">
										
						                 	
									</div>
								</div>
							</div>
							-->
						</div>
					</div>
					
				</div>
			</section>			
			<section id="footer-bar">
				<div class="row">
					<div class="span3">
						<h4>Navigation</h4>
						<ul class="nav">
							<li><a href="./index.html">Homepage</a></li>  
							<li><a href="./about.html">About Us</a></li>
							<li><a href="./contact.html">Contac Us</a></li>
							<li><a href="./cart.html">Your Cart</a></li>
							<li><a href="./register.html">Login</a></li>							
						</ul>					
					</div>
					<div class="span4">
						<h4>My Account</h4>
						<ul class="nav">
							<li><a href="#">My Account</a></li>
							<li><a href="#">Order History</a></li>
							<li><a href="#">Wish List</a></li>
							<li><a href="#">Newsletter</a></li>
						</ul>
					</div>
					<div class="span5">
						<p class="logo"><img src="themes/images/logo.png" class="site_logo" alt=""></p>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. the  Lorem Ipsum has been the industry's standard dummy text ever since the you.</p>
						<br/>
						<span class="social_icons">
							<a class="facebook" href="#">Facebook</a>
							<a class="twitter" href="#">Twitter</a>
							<a class="skype" href="#">Skype</a>
							<a class="vimeo" href="#">Vimeo</a>
						</span>
					</div>					
				</div>	
			</section>
			<section id="copyright">
				<span>Copyright 2013 bootstrappage template  All right reserved.</span>
			</section>
		</div>
		<script src="themes/js/common.js"></script>
		<script>
		//	$(function () {
			//	$('#myTab a:first').tab('show');
				//$('#myTab a').click(function (e) {
					//e.preventDefault();
				//	$(this).tab('show');
				//})
			//})
			$(document).ready(function() {
				$('.thumbnail').fancybox({
					openEffect  : 'none',
					closeEffect : 'none'
				});
				
				$('#myCarousel-2').carousel({
                    interval: 2500
                });	
				
				$("#myTab li").css({"border":"2px grey solid","cursor":"pointer"});
				$("#myTab li").filter(".active").css({border:"2px orange solid"});
				$("#myTab li").click(function(){
					$("#myTab li").css({border:"2px grey solid"});
					$(this).css({border:"2px orange solid"});
					if($(this).hasClass("a")){
						$("#home").css({display:"block"});
				        $("#profile").css({display:"none"});
				
					}
			        else if($(this).hasClass("b")){
				    $("#profile").css({display:"block"});
		             $("#home").css({display:"none"});
		
			        }
				
				});
			});
		</script>
    </body>
</html>