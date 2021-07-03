<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1> ${course.name}</h1>
<p> Instructor: ${course.instructor}</p>
<p> Sign ups: ${course.signups}</p>
<table class="table" style="width:500px;">
	<tr>
	<th>Name</th>
	<th> Sign Up Dates</th>
	<th>Action</th>
	</tr>
	<c:forEach items="${join}" var="users">
	<tr>
	<th>${users.user.firstName} ${users.user.lastName}</th>
	<th>${users.createdAt}</th>
	<c:choose>
	<c:when test="${(users.user.id).equals(currentUser.id)}">
	<th><a href="/removeJoin/${course.id}">Remove</a></th>
	</c:when>
	<c:otherwise>
	<th> </th>
	</c:otherwise>
	</c:choose>
	</tr>
	</c:forEach>
	</table>
	<form action="/courses/${course.id}/edit" method="get">
	<input type="submit" value="Edit Course">
	</form>
	<form action="/delete/${course.id}" method="get">
	<input type="submit" value="Delete Course" >
	</form>
</body>
</html>