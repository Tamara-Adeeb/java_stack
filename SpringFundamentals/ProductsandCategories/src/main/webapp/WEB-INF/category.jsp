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
<h1> ${category.name}</h1>
<h3>Products: </h3>
<ol>
<c:forEach items="${category.products}" var="productsCategory">
<li>${productsCategory.name}</li>
</c:forEach>
</ol>
<form action="/addProduct-toCategory/${category.id}" method="post">
		Add Products: <select name="product">
		<c:forEach items="${products}" var="product">
			<option value="${product.id}">${product.name}</option>
		</c:forEach>
		</select>
		<input type="submit" value="Add" />
	</form>

</body>
</html>