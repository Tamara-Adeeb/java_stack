<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.firstName} ${user.lastName}" /></h1>
	<a href="/logout">Logout</a>
	<h3>Courses</h3>
	<table class="table" style="width:500px;">
	<tr>
	<th>Course</th>
	<th> Instructor</th>
	<th>Signups</th>
	<th>Action</th>
	</tr>
	<c:forEach items="${courses}" var="course">
	<tr>
	<td><a href="courses/${course.id}"> ${course.name} </a></td>
	<td>${course.instructor}</td>
	<td>${course.signups}/${course.capacity}</td>
	<c:choose>
	<c:when test = "${(course.signups).equals(course.capacity)}">
	<td> Full</td>
	</c:when>
	<c:when test = "${(course.users).contains(user)}">
	<td>Already Add </td>
	</c:when>
	<c:otherwise>
	<td><a href="/join/${course.id}"> Add</a></td>
	</c:otherwise>
	</c:choose>
	</tr>
	</c:forEach>
	</table>
	<form action="/courses/new" method="get">
	<input type="submit" value="Add Course">
	</form>
</body>
</html>