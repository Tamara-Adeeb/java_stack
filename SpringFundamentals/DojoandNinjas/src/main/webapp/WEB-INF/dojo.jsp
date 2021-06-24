<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> New Dojo</h1>
<form:form action="/addDojo" method="post" modelAttribute="dojo">
	<form:label path="title">  Name</form:label>
	<form:input path="title"/>
	<form:errors path="title"/>
	<input type="submit" value="Create"/>
</form:form>

</body>
</html>