<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认添加</title>
<link rel="stylesheet" type="text/css" href="my.css">
</head>
<body>
<div>
	<img alt="" src="pic.jpg">
</div>
<div id="container">
<a href="add.jsp">back to last page</a><br>
<a href="adminIndex.jsp">back to main page</a> 
<center>
<s:form action="adminBookAction!add" method="post">
<table width="400px" height="200px">
<caption>新书信息</caption>
<tr><th>BookName:</th><td><input type="text" name="book.bookname" value="${bookname}"></td></tr>
<tr><th>Author:</th><td><input type="text" name="book.author" value="${author}"></td></tr>
<tr><th>BookCounts:</th><td><input type="text" name="book.bookcounts" value="${bookcounts}"></td></tr>
<tr><th>Category:</th><td><input type="text" name="book.category" value="${category}"></td></tr>
<tr><th>Introduction:</th><td><input type="text" name="book.introduction" value="${introduction}"></td></tr>
<tr><th>Image:</th><td><input type="text" name="book.cover" value="${cover}"></td></tr>
<tr><td colspan="2" style="text-align:center;"><s:submit value="confirm" class="btn"></s:submit></td></tr>
</table>
</s:form>
</center>
</div>
</body>
</html>