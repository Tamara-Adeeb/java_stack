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
	<p>Title ${song.title}</p>
	<p>Artist ${song.artist}</p>
	<p>Rating(1-10) ${song.rating}</p>
	<a href="/delete/${song.id}">delete</a>
</body>
</html>