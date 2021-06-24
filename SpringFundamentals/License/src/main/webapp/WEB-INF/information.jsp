<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>License #</th>
	<th>State</th>
	<th>Expiration Date</th>
	</tr>
	<c:forEach items="${licenses}" var="license">
	<tr>
	<th> ${license.person.firstName}</th>
	<th> ${license.person.lastName}</th>
	<th> ${license.number}</th>
	<th> ${license.state}</th>
	<th> ${license.expirationDate}</th>
	</tr>
	</c:forEach>
	</table>

</body>
</html>