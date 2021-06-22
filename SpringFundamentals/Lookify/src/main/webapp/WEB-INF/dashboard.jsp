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
	<a href="/songs/new">Add New</a>
	<a href="/search/topTen">Top Songs</a>
	<form action="/search" method="post">
	<input type="text" name="artist"/>
	<input type="submit" value="Serch"/>
	</form>
	<table>
		<tr>
			<th>Name</th>
			<th>Rating</th>
			<th>action</th>
		</tr>
		<c:forEach items="${songs}" var="song">
			<tr>
				<td><a href="songs/${song.id}">${song.title}</a></td>
				<td>${song.rating}</td>
				<td><a href="delete/${song.id}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>