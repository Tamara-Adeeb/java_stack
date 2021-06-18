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
	<p>
		this is by 2 counter:
		<c:out value="${counter}" />
	</p>
	<p>
		<%
		out.print(session.getAttribute("counterByTwo"));
		%>
	</p>
	<a href="/"> Test another visit </a>
	<form action="/rest">
	<input type="submit" value="Rest"/>
	</form>
</body>
</html>