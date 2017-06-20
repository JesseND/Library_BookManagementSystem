<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书添加</title>
<link rel="stylesheet" type="text/css" href="add.css">
<s:head/>
</head>
<body>
<div>
	<img alt="" src="pic.jpg">
</div>
<div id="container">
<a href="adminIndex.jsp">back to main page</a> 
<center>
<s:form action="addAction" method="post">
<table width="400px" height="200px">
<caption>新书信息</caption>
<tr><td><s:textfield name="bookname" label="bookname"></s:textfield></td></tr>
<tr><td><s:textfield name="author" label="author"></s:textfield></td></tr>
<tr><td><s:textfield  name="bookcounts" label="bookcounts"></s:textfield></td></tr>
<tr>
<td>
<s:select name="category" list="#{'510101':'510101','510102':'510102','510103':'510103','510104':'510104','510105':'510105','510107':'510107','510108':'510108'}"
 label="category" listKey="key" listValue="value"></s:select>
</td>
</tr>
<tr><td><s:textfield name="introduction" label="introduction" ></s:textfield></td></tr>
<tr><td><s:textfield name="image" label="image" ></s:textfield></td></tr>
<tr><td colspan="2" style="text-align:center;" ><s:submit value="Add" class="btn"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;<s:reset class="btn" value="reset"></s:reset></td></tr>
</table>
</s:form>
</center>
</div>
</body>
</html>