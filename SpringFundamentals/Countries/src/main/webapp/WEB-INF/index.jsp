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
<table>
<tr>
<th>Country Name </th>
<th>Country language </th>
<th>Country percentage </th>
</tr>
<c:forEach items="${first}" var="one">
<tr>
<td>${one[0]}</td>
<td>${one[1]}</td>
<td>${one[2]}</td>
</tr>
</c:forEach>
</table>
</body>
</html>