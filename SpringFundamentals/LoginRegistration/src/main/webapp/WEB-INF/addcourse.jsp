<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1> Create a new course </h1>
<form:form action="/addCourse"  method="post" modelAttribute="course" style="margin-left:10px;margin-bottom:10px;">
<div class="form-group row">
			<form:label path="name" class="col-sm-2 col-form-label" > Name: 	</form:label>
			<form:input path="name" class="form-control" style="width:200px;"/>
			<form:errors path="name" />
		</div>
		<div class="form-group row">
			<form:label path="instructor" class="col-sm-2 col-form-label" >Instructor:</form:label>
			<form:input path="instructor" class="form-control" style="width:200px;"/>
			<form:errors path="instructor" />
		</div>
		<div class="form-group row">
			<form:label path="capacity" class="col-sm-2 col-form-label" > Capacity: </form:label>
			<form:input path="capacity" class="form-control" style="width:200px;"/>
			<form:errors path="capacity" />
		</div>
		
<input type="submit" value="Create" >
</form:form>

</body>
</html>