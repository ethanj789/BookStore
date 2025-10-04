<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<body>
<h3>Add Book</h3>
<form action = "BookstoreController" method = "GET">
	<input type= "hidden" name = "command" value = "ADD"/>

	<table>
		<tbody>
			<tr>
				<td><label>Title:</label></td><td><input type = "text" name = "title" /></td>
			</tr>
			<tr>
				<td><label>Author:</label></td><td><input type = "text" name = "author" /></td>
			</tr>
			<tr>
				<td><label>Price:</label></td><td><input type = "text" name = "price" /></td>
			</tr>
		</tbody>	
	</table>
	<input type = "submit" value = "Add book"/>
</form>
<input type = "button" value = "cancel" onclick="window.location.href='BookstoreController?command=LIST';"/>

</body>
</html>