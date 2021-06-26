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
<h1>${question.question}</h1>
<h3> Tags:<c:forEach items="${question.tags}" var="tag">
<li> ${tag.subject}</li>
</c:forEach> </h3>
<ol>
<c:forEach items="${question.answers}" var="answer">
<li> ${answer.answer}</li>
</c:forEach>
</ol>

<form action="/addAnswer/${question.id}" method="post">
Answer:
<textarea name="answer"></textarea>
<input type="submit" value="Answer it!"/>
</form>

</body>
</html>