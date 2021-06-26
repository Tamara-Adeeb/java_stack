<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${product.name}</h1>
	<h3>Categories:</h3>
	<ul>
		<c:forEach items="${product.categories}" var="productCategory">
			<li>${productCategory.name}</li>
		</c:forEach>
	</ul>
	<form action="/addCategory-toProduct/${product.id}" method="post">
		Add Category: <select name="category">
		<c:forEach items="${catogories}" var="category">
			<option value="${category.id}">${category.name}</option>
		</c:forEach>
		</select>
		<input type="submit" value="Add" />
	</form>


</body>
</html>