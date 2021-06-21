<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:out value="${book.title}"/>
<p> Description: <c:out value="${book.description}"></c:out></p>
<p> Language: <c:out value="${book.language}"></c:out></p>
<p> Number of Pages: <c:out value="${book.numberOfPages}"/></p>

<a href="/books/${book_id}/edit"> Edit </a>


</body>
</html>