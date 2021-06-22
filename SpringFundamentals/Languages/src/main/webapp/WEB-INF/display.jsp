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
<table>
<tr> 
<th> Name </th>
<th> Creator </th>
<th> Version </th>
<th> action </th>
</tr>
<c:forEach items="${all_Languages}" var="language">
<tr>
<td><a href="/languages/${language.id}">${language.name}</a></td>
<td> ${language.creator}</td>
<td> ${language.version}</td>
<td><a href="/delete/${language.id}">delete</a><a href="/languages/edit/${language.id}">edit</a></td>
</tr>
</c:forEach>
</table>
<form:form action="/create" method="Post" modelAttribute="language">
<p>
<form:label path="name">Name</form:label>
<form:input path="name"/>
<form:errors path="name"/>
</p>
<p>
<form:label path="creator">Creator</form:label>
<form:input path="creator"/>
<form:errors path="creator"/>
</p>
<p>
<form:label path="version">Version</form:label>
<form:input path="version"/>
<form:errors path="version"/>
</p>
<input type="submit" value="Submit"/>
</form:form>

</body>
</html>