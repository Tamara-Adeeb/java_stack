<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/dashboard">Dashboard</a>
	<form:form action="/create" method="post" modelAttribute="song">
		<p>
			<form:label path="title"> Title </form:label>
			<form:input path="title" />
			<form:errors path="title" />
		</p>
		<p>
			<form:label path="artist"> Artist </form:label>
			<form:input path="artist" />
			<form:errors path="artist" />
		</p>
		<p>
			<form:label path="rating"> Rating from(1-10) </form:label>
			<form:select path="rating">
				<form:option value="1" />
				<form:option value="2" />
				<form:option value="3" />
				<form:option value="4" />
				<form:option value="5" />
				<form:option value="6" />
				<form:option value="7" />
				<form:option value="8" />
				<form:option value="9" />
				<form:option value="10" />
			</form:select>
			<form:errors path="rating" />
		</p>
		<input type="submit" value="Add Song"/>
	</form:form>

</body>
</html>