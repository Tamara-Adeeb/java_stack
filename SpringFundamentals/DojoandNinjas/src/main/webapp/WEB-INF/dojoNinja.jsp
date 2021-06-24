<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th> First Name </th>
<th> Last Name </th>
<th> Age </th>	
</tr>
<c:forEach items="${dojo.ninjas}" var="ninja">
<tr>
<td>${ninja.firstName} </td>
<td>${ninja.lastName} </td>
<td>${ninja.age} </td>
</tr>
</c:forEach>
</table>

</body>
</html>