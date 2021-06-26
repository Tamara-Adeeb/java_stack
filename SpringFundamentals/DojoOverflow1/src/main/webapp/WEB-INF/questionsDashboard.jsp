<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Questions Dashboard</h1>
	<table>
		<tr>
			<th>Questions</th>
			<th>Tags</th>
		</tr>
		<c:forEach items="${questions}" var="q">
			<tr>
				<td><a href="/question/${q.id}">${q.question}</a></td>
				<td><c:forEach items="${q.tags}" var="tag">
${tag.subject}
</c:forEach></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/questions/new">New Question</a>

</body>
</html>