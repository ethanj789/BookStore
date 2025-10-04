<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Store</title>
</head>
<body>
<h1>Books Available</h1>

<input type = "button" value = "Add Book"
	onClick = "window.location.href = 'add-book-form.jsp'; return false;"/>

<table>
	<tr>
		<th>Id</th>
		<th>Title</th>
		<th>Author</th>
		<th>Price</th>
		<th>Action</th>
	</tr>
	<c:forEach var = "book" items = "${Books}">
	
	<c:url var = "update" value = "BookstoreController">
		<c:param name = "command"     value = "GET" />
		<c:param name = "id"      value = "${book.id}" />
	</c:url>
	<c:url var = "delete" value = "BookstoreController">
		<c:param name = "command"     value = "DELETE" />
		<c:param name = "id"      value = "${book.id}" />
	</c:url>
	
		<tr>
			<td>${book.id}. </td>
			<td>${book.title}</td>
			<td>${book.author}</td>
			<td>${book.price}</td>
			<td><a href= "${update}">Update</a> | <a href = "${delete}" onclick="return confirm('Are you sure you want to delete this book?');">Delete</a></td>
		</tr>
	</c:forEach>
</table>


</body>
</html>