<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en-US" xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
	<title>Book Management System</title>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<link rel="shortcut icon" href="css/images/favicon.ico" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" src="js/jquery.jcarousel.min.js"></script>
	<!--[if IE 6]>
		<script type="text/javascript" src="js/png-fix.js"></script>
	<![endif]-->
	<script type="text/javascript" src="js/functions.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script src="js/myfx.js"></script>
	<script>
	$(document).ready(function(){
	    var status = $(".logstat").attr("id");
	  
	    if(status=="logged"){
	    	
	    	$(".unlogged").css({display:"none"});
	    	$(".logged").css({dispay:"inline"});
	    }
	    else{
	    	
	    	$(".logged").css({display:"none"});
	    	$(".unlogged").css({dispay:"inline"});
	    }
	})
 
    
	</script>
</head>
<body>
	<!-- Header -->
	<div id="header" class="shell">
		<div id="logo"><h1><a >Q Library</a></h1><span><a href="#">Borrow Books Online</a></span></div>
		<!-- Navigation -->
		<div id="navigation">
			<ul>
				<li><a href="index.jsp" class="active">Home</a></li>
				<li><a href="bookAction!toBooks">Books</a></li>
				<li><a href="borrowAction!myHistory">My History</a></li>
				<li><a href="contact.html">Contacts Us</a></li>
			
			</ul>
		</div>
		<!-- End Navigation -->
		<div class="cl">&nbsp;</div>
		<!-- Login-details -->
		<h1>the status is ${status }</h1>
		<input type="hidden" id="${status }" class="logstat"></input>
		
		<div id="login-details" class="unlogged" >
						<p>Welcome <i class="guest">Guest</i> ,&nbsp;&nbsp;</p> <p> <a href="register.html" id="user" class="guest">Sign-in/Sign-up</a> </p> <p><a href="#" class="cart" ><img src="css/images/cart-icon.png" alt="" /></a>Borrowed Books (0) <a href="#" class="sum"></a></p>
		
		</div>
		
		<div id="login-details" class="logged" >
				<p>Welcome ${name } <i class="glogged" style="color:red">${user_name }</i>,&nbsp;&nbsp;</p> <p><a href="userAction!logout" id="user" class="glogged">logout</a>  </p> <p><a href="#" class="cart" ><img src="css/images/cart-icon.png" alt="" /></a>Borrowed Books (0) <a href="#" class="sum"></a></p>
		
		</div>
		
		
	
		<!-- End Login-details -->
		<div class="search">
			
		</div>
	</div>
	<!-- End Header -->
	<!-- Slider -->

	<div id="slider">
		<div class="shell">
			<ul>
				<li>
					<div class="image">
						<img src="css/images/books.png" alt="" />
					</div>
					<div class="details">
						<h2>Bestsellers</h2>
						<h3>Special Offers</h3>
						<p class="title">Pellentesque congue lorem quis massa blandit non pretium nisi pharetra</p>
						<p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent id odio in tortor scelerisque dictum. Phasellus varius sem sit amet metus volutpat vel vehicula nunc lacinia.</p>
						<a href="#" class="read-more-btn">Read More</a>
					</div>
				</li>
				<li>
					<div class="image">
						<img src="css/images/books.png" alt="" />
					</div>
					<div class="details">
						<h2>Bestsellers</h2>
						<h3>Special Offers</h3>
						<p class="title">Pellentesque congue lorem quis massa blandit non pretium nisi pharetra</p>
						<p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent id odio in tortor scelerisque dictum. Phasellus varius sem sit amet metus volutpat vel vehicula nunc lacinia.</p>
						<a href="#" class="read-more-btn">Read More</a>
					</div>
				</li>
				<li>
					<div class="image">
						<img src="css/images/books.png" alt="" />
					</div>
					<div class="details">
						<h2>Bestsellers</h2>
						<h3>Special Offers</h3>
						<p class="title">Pellentesque congue lorem quis massa blandit non pretium nisi pharetra</p>
						<p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent id odio in tortor scelerisque dictum. Phasellus varius sem sit amet metus volutpat vel vehicula nunc lacinia.</p>
						<a href="#" class="read-more-btn">Read More</a>
					</div>
				</li>
				<li>
					<div class="image">
						<img src="css/images/books.png" alt="" />
					</div>
					<div class="details">
						<h2>Bestsellers</h2>
						<h3>Special Offers</h3>
						<p class="title">Pellentesque congue lorem quis massa blandit non pretium nisi pharetra</p>
						<p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent id odio in tortor scelerisque dictum. Phasellus varius sem sit amet metus volutpat vel vehicula nunc lacinia.</p>
						<a href="#" class="read-more-btn">Read More</a>
					</div>
				</li>
			</ul>
			<div class="nav">
				<a href="#">1</a>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
			</div>
		</div>
	</div>
	<!-- End Slider -->
	<!-- Main -->
	<div id="main" class="shell">
		<!-- Sidebar -->
		<div id="sidebar">
			<ul class="categories">
				<li>
					<h4>Categories</h4>
					<ul class="catlist">
					<script>
					  $(".catlist").load("categoryAction");
					</script>
					</ul>
				</li>
		
			</ul>
		</div>
		<!-- End Sidebar -->
		<!-- Content -->
		<div id="content">
			<!-- Products -->
			<div class="products">
				<h3>Featured Products</h3>
				<ul>
				<s:iterator value="briefBook" var="book">
					<li>
						<div class="product" id="${book.category }">
							<a href="bookdetailAction?book_id=${book.id }&cat_id=${book.category }" class="info">
								<span class="holder">
									<img src="${book.cover }" alt="${book.bookname }" />
									<span class="book-name"> ${book.bookname }</span>
									<span class="author">By :${book.author }</span>
									<span class="description">${book.briefIntro}</span>
								</span>
							</a>
							<a href="bookdetailAction?book_id=${book.id }&cat_id=${book.category }" class="buy-btn">View Now </a>
						</div>
					</li>
					
					</s:iterator>
			
				</ul>
			<!-- End Products -->
			<div class="more" style="width:100%;text-align:center;font-size:20px;"><a href="bookAction!toBooks" style="color:red">View All Books...</a></div>
			</div>
			<div class="cl">&nbsp;</div>
			<!-- Best-sellers -->
			<div id="best-sellers">
				<h3>New Arrivals</h3>
				<ul>
				<s:iterator value="dtbooks" var="bbook">
					<li>
						<div class="product" id="">
							<a href="bookdetailAction?book_id=${bbook.id }&cat_id=${bbook.category }">
								<img src="${bbook.cover }" alt="${bbook.bookname }" />
								<span class="book-name">${bbook.bookname } </span>
								<span class="author">${bbook.author }</span>
								<span class="price">New</span>
							</a>
						</div>
					</li>
				</s:iterator>	
			
				</ul>
			</div>
			<!-- End Best-sellers -->
		</div>
		<!-- End Content -->
		<div class="cl">&nbsp;</div>
	</div>
	<!-- End Main -->
	<!-- Footer -->
	<div id="footer" class="shell">
		<div class="top">
			<div class="cnt">
				<div class="col about">
					<h4>About BestSellers</h4>
					<p>Nulla porttitor pretium mattis. Mauris lorem massa, ultricies non mattis bibendum, semper ut erat. Morbi vulputate placerat ligula. Fusce <br />convallis, nisl a pellentesque viverra, ipsum leo sodales sapien, vitae egestas dolor nisl eu tortor. Etiam ut elit vitae nisl tempor tincidunt. Nunc sed elementum est. Phasellus sodales viverra mauris nec dictum. Fusce a leo libero. Cras accumsan enim nec massa semper eu hendrerit nisl faucibus. Sed lectus ligula, consequat eget bibendum eu, consequat nec nisl. In sed consequat elit. Praesent nec iaculis sapien. <br />Curabitur gravida pretium tincidunt.  </p>
				</div>
				<div class="col store">
					<h4>Store</h4>
					<ul>
						<li><a href="#">Home</a></li>
						<li><a href="#">Special Offers</a></li>
						<li><a href="#">Log In</a></li>
						<li><a href="#">Account</a></li>
						<li><a href="#">Basket</a></li>
						<li><a href="#">Checkout</a></li>
					</ul>
				</div>
				<div class="col" id="newsletter">
					<h4>Newsletter</h4>
					<p>Lorem ipsum dolor sit amet  consectetur. </p>
					<form action="" method="post">
						<input type="text" class="field" value="Your Name" title="Your Name" />
						<input type="text" class="field" value="Email" title="Email" />
						<div class="form-buttons"><input type="submit" value="Submit" class="submit-btn" /></div>
					</form>
				</div>
				<div class="cl">&nbsp;</div>
				<div class="copy">
					<p>&copy; <a href="#">BestSeller.com</a>. Design by <a href="http://css-free-templates.com/">CSS-FREE-TEMPLATES.COM</a></p>
				</div>
			</div>
		</div>
	</div>
	<!-- End Footer -->
</body>
</html>