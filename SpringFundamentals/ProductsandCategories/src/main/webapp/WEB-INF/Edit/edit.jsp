<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/edit/${course.id}" method="post" modelAttribute="course">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="instructor">instructor</form:label>
        <form:errors path="instructor"/>
        <form:textarea path="instructor"/>
    </p>
    <p>
        <form:label path="capacity">Capacity</form:label>
        <form:errors path="capacity"/>
        <form:input path="capacity"/>
    </p>   
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>