<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	
	<h4>Top Ten Songs:</h4>
	<c:forEach items="${topTenSongs}" var="song">
		<p>${song.rating} - <a href="songs/${song.id}">${song.title}</a> - ${song.artist}</p>
	</c:forEach>


</body>
</html>