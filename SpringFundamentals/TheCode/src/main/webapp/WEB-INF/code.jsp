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
		<c:out value="${error}" />
		<c:out value="${error2}" />
	</p>
	<p>What is the code</p>
	<form action="/check" method="post">
		<input type="text" name="codeValue" /> <input type="submit"
			value="Try Code" />
	</form>
</body>
</html>