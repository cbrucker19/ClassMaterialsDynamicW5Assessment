<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "EditListDetailsServlet" method="post">
<input type ="hidden" name = "id" value= "${listToEdit.id}">
List Name: <input type ="text" name = "listName" value= "${listToEdit.listName}"><br />
Course Start Date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}"> 
<input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">, <input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
Shopper Name: <input type = "text" name = "shopperName" value= "${listToEdit.student.studentName}"><br />

Available Items:<br />

<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
   <option value = "${currentitem.id}">${currentitem.course} | ${currentitem.book}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value="Edit List and Add Items">
</form>
<a href = "index.html">Go add new items instead.</a>
</body>
</html>