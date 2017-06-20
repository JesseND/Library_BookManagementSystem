<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"  %>
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
    <link href="themes/css/flexslider.css" rel="stylesheet"/>
    <link href="themes/css/main.css" rel="stylesheet"/>

    <!-- scripts -->
    <script src="themes/js/jquery-1.7.2.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="themes/js/superfish.js"></script>
    <script src="themes/js/jquery.scrolltotop.js"></script>
    <script src="js/myfx.js"></script>
    <script type="text/javascript">   
    function returnbook(bookId){
 
    	 window.location="borrowAction!returnBook?bookId="+bookId;
    	
    }	
    </script>
    
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <script src="themes/js/respond.min.js"></script>
    <![endif]-->
    
</head>
<body>
<div id="top-bar" class="container">
    <div class="row">
        <div class="search">
            <form action="" method="post">
                <input type="search" placeholder="Search a book or author" id="search_input">
                <input type="submit" value="Search" id="search_btn">
            </form>
        </div>
        <div class="span8 menu-p">
            <div class="account pull-right">
                <ul class="user-menu">
                    <li><a href="index.html" class="active">Home</a></li>
				     <li><a href="bookAction!toBooks">Books</a></li>
				     <li><a href="#" onclick="myhistory()" class="active">My History</a></li>
				    <li><a href="contact.html">Contacts Us</a></li>
                    <li><a href="register.html">Login</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div id="wrapper" class="container">

    <section class="header_text sub">
        <img class="pageBanner" src="themes/images/pageBanner.png" alt="New products" >
        <h4><span>Borrowed Books History</span></h4>
    </section>
    <section class="main-content">
        <div class="row">
            <div class="span9 cart-cont my-borrow">
                <table class="table table-striped cart-cont">
                    <thead>
                    <tr>
                        <th>Select</th>
                        <th>BookId</th>
                        <th>Image</th>
                        <th>Book  Name</th>
                        <th>Book  Author</th>
                        <th>Borrow time</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="borrowhistory" var="bh">
                             <tr>
                             <td><input type="checkbox" class="ch" name="boo" value="${bh.bookId }"></td>
                             <td>${bh.bookId}</td>
                             <td><img alt="image not available" src="${bh.cover}"></td>
                             <td>${bh.bookname}</td>
                              <td>${bh.bookauthor}</td>
                              <td>${bh.borrowtime}</td>
                              <td>${bh.status}</td>
                              <td>
                              <s:if test= '#bh.status=="Not Returned"'>
                                         <a href="returnBookAction?bookId=${bh.bookId }"><input type="button"  value="return"></a>
                                                 
                              </s:if>
                            </td>
                         </tr>
                    </s:iterator>
                    </tbody>
                    </table>
            </div>

        </div>
    </section>
    <section id="footer-bar">
        <div class="row">
            <div class="span3">
                <h4>Navigation</h4>
                <ul class="nav">
                    <li><a href="./main.jsp">Home page</a></li>
                    <li><a href="./about.html">About Us</a></li>
                    <li><a href="./contact.html">Contact Us</a></li>
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