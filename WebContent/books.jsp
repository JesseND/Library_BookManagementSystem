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
		
		<!-- global styles -->
		<link href="themes/css/flexslider.css" rel="stylesheet"/>
		<link href="themes/css/main.css" rel="stylesheet"/>
		<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

		<!-- scripts -->
		<script src="themes/js/jquery-1.7.2.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>				
		<script src="themes/js/superfish.js"></script>	
		<script src="themes/js/jquery.scrolltotop.js"></script>
			<script type="text/javascript" src="js/index.js"></script>
			<script>
			function get(page){
//				alert($(".pg1").attr("id"));
//				alert($(".pgl").attr("id"));
//				alert(page);
				
				var url = "bookAction!toBooks?page="+page;
				$("body").load(url);

			}
			</script>
		<!--[if lt IE 9]>			
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->
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
				<h4><span>A l l &nbsp; &nbsp;B o o k s</span></h4>
			</section>
			<section class="main-content">
				
				<div class="row" style="width:100%;">						
					<div class="span9" style="text-align:center;width:80%;margin-left:13%;">								
						<ul class="thumbnails listing-products">
							<s:iterator value="books" var="cbook">
							<li class="span3">
								<div class="product-box">
									<span class="sale_tag"></span>												
									<a href="bookdetailAction?book_id=${cbook.id }&cat_id=${cbook.category}"><img alt="" src="${cbook.cover }"></a><br/>
									<a href="bookdetailAction?book_id=${cbook.id }&cat_id=${cbook.category}"  class="title">${cbook.bookname }</a><br/>
									<a href="bookdetailAction?book_id=${cbook.id }&cat_id=${cbook.category}" class="category">By: ${cbook.author }</a>
								</div>
							</li> 
							</s:iterator>
							      
				
						</ul>								
						<hr>
						<div class="pagination pagination-small pagination-centered">
							<ul>
							<input type="hidden" class="pg1" id="${page }">
							<input type="hidden" class="pgl" id="${lastPage }">
							
							<s:if test="page==1">
							 
							 <li ><a href="javascript:void(0);" onClick="get(1)" style="margin-left:-5px;background:gray;color:white;" class="prev-btn">Prev</a></li>
								<li class="active" style="visibility:hidden"><a href="#" >1</a></li>
								<li style="visibility:hidden"><a href="#">2</a></li>
								<li style="visibility:hidden"><a href="#">3</a></li>
								<li style="visibility:hidden"><a href="#">4</a></li>
								<li class="next-btn"><a href="javascript:void(0);" onClick="get(${page+1})" style="margin-left:15px;background:orange;color:white;">Next</a></li>
							</s:if>
							    <s:elseif test="page==lastPage">
							        <li ><a href="javascript:void(0);" onClick="get(${page-1})" style="margin-left:-5px;background:orange;color:white;" class="prev-btn">Prev</a></li>
								<li class="active" style="visibility:hidden"><a href="#" >1</a></li>
								<li style="visibility:hidden"><a href="#">2</a></li>
								<li style="visibility:hidden"><a href="#">3</a></li>
								<li style="visibility:hidden"><a href="#">4</a></li>
								<li class="next-btn"><a href="javascript:void(0);" onClick="get(${lastPage})" style="margin-left:15px;background:gray;color:white;">Next</a></li>
							    </s:elseif>
							<s:else>
							     <li ><a href="javascript:void(0);" onClick="get(${page-1})" style="margin-left:-5px;background:orange;color:white;" class="prev-btn">Prev</a></li>
								<li class="active" style="visibility:hidden"><a href="#" >1</a></li>
								<li style="visibility:hidden"><a href="#">2</a></li>
								<li style="visibility:hidden"><a href="#">3</a></li>
								<li style="visibility:hidden"><a href="#">4</a></li>
								<li class="next-btn"><a href="javascript:void(0);" onClick="get(${page+1})" style="margin-left:15px;background:orange;color:white;">Next</a></li>
							</s:else>
							
							
							</ul>
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
    </body>
</html>