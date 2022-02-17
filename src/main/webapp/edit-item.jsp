<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Item page</title>
</head>
<body>
	<form action="EditItemServlet" method="post">
	Book: <input type="text" name="course" value="${itemToEdit.course}">
	Course: <input type="text" name="book" value="${itemToEdit.book}">
	<input type="hidden" name="id" value="${itemToEdit.id}">
	<input type="submit" value="Saved Edited Item">
	</form>
</body>
</html>