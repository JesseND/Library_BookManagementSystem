<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<td>No</td>
<td>Book name</td>
<td>Borrower</td>
<td>Borrow Time</td>
<td>Status</td>
</tr>

<s:iterator value="archive" var="a">
<tr>
<td>${a.id}</td>
<td>${a.bookname}</td>
<td>${a.borrower}</td>
<td>${a.borrowtime}</td>
<td>${a.status}</td>
</tr>
</s:iterator>
</table>

</body>
</html>