<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理中心</title>
<link rel="stylesheet" type="text/css" href="my.css">
<script type="text/javascript" src="jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="my.js"></script>
<script type="text/javascript">
</script>
</head>
<body style="width:100%;">
<div>
	<img alt="" src="pic.jpg">
</div>
<div class="menu">
<a href="adminBorrowAction!records" >View all books which were borrowed</a>&nbsp;||&nbsp;
<a href="add.jsp">add new book</a>&nbsp;||&nbsp;
<a href="userAction!logout">Exit</a>
</div>
<div id="container">
	<div id="right">
		<%@ include file="adminBooks.jsp" %>
	</div>
</div>



</body>
</html>