<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book</title>
</head>
<body>
<h3>Update Book</h3>
<form action = "BookstoreController" method = "GET">
	<input type= "hidden" name = "command" value = "UPDATE"/>
	<input type = "hidden" name = "id" value = "${BOOK.id}" />

	<table>
		<tbody>
			<tr>
				<td><label>Title:</label></td><td><input type = "text" name = "title" value = "${BOOK.title}" /></td>
			</tr>
			<tr>
				<td><label>Author:</label></td><td><input type = "text" name = "author" value = "${BOOK.author}" /></td>
			</tr>
			<tr>
				<td><label>Price:</label></td><td><input type = "text" name = "price" value = "${BOOK.price}"/></td>
			</tr>
		</tbody>	
	</table>
	<input type = "submit" value = "Update book"/>
</form>
<input type = "button" value = "cancel" onclick="window.location.href='BookstoreController?command=LIST';"/>

</body>
</html>