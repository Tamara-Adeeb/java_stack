<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/surveyData" method="post">
		Your Name: <input type="text" name="name" /> Dojo Location: <select
			name="location">
			<option value="Palestine">Palestine</option>
			<option value="San M">San M</option>
			<option value="San F">San F</option>
		</select> Favorite Language: <select name="fav">
			<option value="python">Python</option>
			<option value="java">Java</option>
			<option value="javaScript">JavaScript</option>
		</select> Comment:
		<textarea name="comment"></textarea>
		<input type="submit" value="Button"/>
	</form>

</body>
</html>