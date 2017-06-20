<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Hello Boy!</h1>
  <table> 
   <tr><th>ID</th><th>bookID</th><th>userId</th><th>Borrow time</th><th>returned</th>
   <br>
    <s:iterator value="borrows" var="borrow">
       <tr><td>${borrow.id}</td><td>${borrow.bookid}</td>
       <td>${borrow.userid}</td><td>${borrow.borrowtime}</td><td>${borrow.returned}</td>
    </s:iterator>
   </table>
   <form action="borrowAction!borrowBook" method="post">
      <input type="submit" value="Borrow">
   </form>
    <form action="borrowAction!returnBook" method="post">
      <input type="submit" value="Return">
   </form>
</body>
</html>