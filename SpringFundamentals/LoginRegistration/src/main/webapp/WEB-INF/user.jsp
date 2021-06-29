<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<Style>
h1,h3{
margin:5px;
}
</Style>
</head>
<body>
	<h1>Welcome</h1>
	<h3>Register</h3>
	<form:form action="/registration" method="post" modelAttribute="user" style="margin-left:10px;margin-bottom:10px;">
		<div class="form-group row">
			<form:label path="firstName" class="col-sm-2 col-form-label" > First Name</form:label>
			<form:input path="firstName" class="form-control" style="width:200px;"/>
			<form:errors path="firstName" />
		</div>
		<div class="form-group row">
			<form:label path="lastName" class="col-sm-2 col-form-label" > Last Name</form:label>
			<form:input path="lastName" class="form-control" style="width:200px;" />
			<form:errors path="lastName" class="form-control" style="width:200px;" />
		</div>
		<div class="form-group row">
			<form:label path="email" class="col-sm-2 col-form-label" > Email</form:label>
			<form:input path="email" class="form-control" style="width:200px;"/>
			<c:out value="${error1}" />
			<form:errors path="email" />
		</div>
		<div class="form-group row">
			<form:label path="password" class="col-sm-2 col-form-label" > Password</form:label>
			<form:input type="password" path="password" class="form-control" style="width:200px;"/>
			<form:errors path="password" />
		</div>
		<div class="form-group row">
			<form:label path="PasswordConfirmation" class="col-sm-2 col-form-label" > Password Confirmation</form:label>
			<form:input type="password" path="PasswordConfirmation" class="form-control" style="width:200px;"/>
			<form:errors path="PasswordConfirmation"/>
		</div>
		<input type="submit" value="Register" />
	</form:form>
	<h3>Login</h3>
	<p><c:out value="${error}" /></p>
	<form method="post" action="/login" style="margin-left:10px;">
		<div class="form-group row">
			<label for="email" class="col-sm-2 col-form-label" >Email</label> <input type="text" id="email"
				name="email" class="form-control" style="width:200px;"/>
		</div>
		<div class="form-group row">
			<label for="password" class="col-sm-2 col-form-label" >Password</label> <input type="password"
				id="password" name="password" class="form-control" style="width:200px;" />
		</div>
		<input type="submit" value="Login!" />
	</form>
</body>
</html>