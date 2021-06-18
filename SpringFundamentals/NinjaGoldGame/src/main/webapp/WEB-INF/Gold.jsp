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
	<p>
		You Gold:
		<c:out value="${countGold}"></c:out>
	</p>
	<form action="/countGold">
		<div>
			<h3>Farm</h3>
			<p>(earns 10-20 gold)</p>
			<input type="hidden" name="gold" value="Farm" /> <input
				type="submit" value="Find Gold!" />
		</div>
		<div>
			<h3>Cave</h3>
			<p>(earns 5-10 gold)</p>
			<input type="hidden" name="gold" value="cave" /> <input
				type="submit" value="Find Gold!" />
		</div>
		<div>
			<h3>House</h3>
			<p>(earns 2-5 gold)</p>
			<input type="hidden" name="gold" value="house" /> <input
				type="submit" value="Find Gold!" />
		</div>
		<div>
			<h3>Casino!</h3>
			<p>(earns/takes 0-50 gold)</p>
			<input type="hidden" name="gold" value="casino" /> <input
				type="submit" value="Find Gold!" />
		</div>
	</form>

</body>
</html>