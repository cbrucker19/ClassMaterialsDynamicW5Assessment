<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CourseTextbookList</title>
</head>
<body>

		<form method="post" action="NavigationServlet">
	<table>
		<c:forEach items="${requestScope.allItems}" var="currentitem">
		<tr>
			<td><input type="radio" name="id" value="${currentitem.id}"></td>
			<td>${currentitem.course}</td>
			<td>${currentitem.book}</td>
		</tr>	
		</c:forEach>
	</table>
	<br />
	<input type="submit" value="edit" name="doThisToItem">
	<input type="submit" value="delete" name="doThisToItem">
	<input type="submit" value="add" name="doThisToItem">
	</form>
</body>
</html>