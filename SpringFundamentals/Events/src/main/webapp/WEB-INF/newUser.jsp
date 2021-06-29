<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome</h1>
<h3>Register</h3>
<form:form action="/registration" method="post" modelAttribute="user">
<p>
<form:label path="firstName"> First Name</form:label>
<form:input path="firstName"/>
<form:errors path="firstName"/>
</p>
<p>
<form:label path="lastName"> Last Name</form:label>
<form:input path="lastName"/>
<form:errors path="lastName"/>
</p>
<p>
<form:label path="email"> Email</form:label>
<form:input path="email"/>
<form:errors path="email"/>
</p>
<p>
<form:label path="location">Location</form:label>
<form:input path="location"/>
<form:errors path="location"/>
<form:select path="state">
<c:forEach items="${user.state}" var="state">
<form:option value="${state}">${state}</form:option>
</c:forEach>
</form:select>
<form:errors path="state"/>
</p>
<p>
<form:label path="password"> Password</form:label>
<form:input type="password" path="password"/>
<form:errors path="password"/>
</p>
<p>
<form:label path="passwordConfirmation"> Password Confirmation</form:label>
<form:input type="password" path="passwordConfirmation"/>
<form:errors path="passwordConfirmation"/>
</p>
<input type="submit" value="Register"/>
</form:form>
<h3>Login</h3>
<p><c:out value="${error}" /></p>
<form method="post" action="/login">
        <p>
            <label for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="submit" value="Login!"/>
    </form>

</body>
</html>