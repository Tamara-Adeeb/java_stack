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
<h1> New License</h1>
<form:form action="/addLicense" method="post" modelAttribute="license">
<p>
<form:label path="person"> Persone: </form:label>
<form:select path="person">
	<c:forEach items="${persons}" var="person">
	<form:option value="${person}">${person.firstName} ${person.lastName}</form:option>
	</c:forEach>
</form:select>
</p>
<p>
<form:label path="state"> State: </form:label>
<form:input path="state"/>
<form:errors path="state"/>
</p>
<p>
<form:label path="expirationDate"> Expiration Date: </form:label>
<form:input path="expirationDate" type="date"/>
<form:errors path="expirationDate"/>
</p>
<input type="submit" value="Create"/>
</form:form>
</body>
</html>