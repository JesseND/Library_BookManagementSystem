<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改图书信息</title>
<link rel="stylesheet" type="text/css" href="my.css">
</head>
<body>
<div>
	<img alt="" src="pic.jpg">
</div>
<div id="container">
<a href="adminIndex.jsp">back to main page</a>
<center>
<form action="adminBookAction!saveModify" method="post">
<table width="400px" height="200px">
<caption>修改图书信息</caption>
<input type="hidden" name="book.id" value="${book.id}">
<input type="hidden" name="book.bookname" value="${book.bookname}"><br>
<input type="hidden" name="book.category" value="${book.category}"><br>
<tr><th>BookCounts:</th><td><input type="text" name="book.bookcounts" value="${book.bookcounts}" class="text1"></td></tr>
<tr><th>BorrowCounts:</th><td><input type="text" name="book.borrowcounts" value="${book.borrowcounts}" class="text2"></td></tr>
<tr><th>Image:</th><td><input type="text" name="book.image" value="${book.cover}" class="text3"></td></tr>
<input type="hidden" name="book.author" value="${book.author}"><br>
<input type="hidden"  name="book.introduction" value="${book.introduction}"><br>
<tr><th colspan="2" style="text-align:center;" ><input type="submit" value="modify" class="btn"></th></tr>
 </table>
</form>
</center>
</div>
</body>
</html>