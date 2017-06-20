<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function modify(id){
	window.location="adminBookAction!modify?id="+id;
}
function del(id){
	var result=confirm("Do you really want to delete this book?");
	if(result==true)
		{
		window.location="adminBookAction!del?id="+id;
		}
}

</script>
</head>
<body>
<table>
<tr>
<td>ID</td>
<td>bookname</td>
<td>author</td>
<td>introduction</td>
<td>bookcounts</td>
<td>borrowcounts</td>
<td>category</td>
<td>image</td>
<td>operation</td>
</tr>

<s:iterator value="books" var="book">
<tr>
<td>${book.id}</td>
<td>${book.bookname}</td>
<td>${book.author}</td>
<td>${book.introduction}</td>
<td>${book.bookcounts}</td>
<td>${book.borrowcounts}</td>
<td>${book.category}</td>
<td>${book.cover}</td>
<td>
<input type="button" value="修改" onclick="modify(${book.id})" name="modify" class="btn"><br>
<input type="button" value="删除" onclick="del(${book.id})" name="del" class="btn"><br>
</td>
</tr>
</s:iterator>
</table>
<br>
<p align="center">
<s:if test="page==1">
First&nbsp;&nbsp;Previous&nbsp;&nbsp;
</s:if>
<s:else>
<a href="javascript:void(0);" onclick="get(1)">First</a>&nbsp;&nbsp;
<a href="javascript:void(0);" onclick="get(${page-1})">Previous</a>&nbsp;&nbsp;
</s:else>

<s:if test="page==lastPage">
Next&nbsp;&nbsp;Last&nbsp;&nbsp;
</s:if>
<s:else>
<a href="javascript:void(0);" onclick="get(${page+1})">Next</a>&nbsp;&nbsp;
<a href="javascript:void(0);" onclick="get(${lastPage})">Last</a>&nbsp;&nbsp;
</s:else>
</p>
</body>
</html>