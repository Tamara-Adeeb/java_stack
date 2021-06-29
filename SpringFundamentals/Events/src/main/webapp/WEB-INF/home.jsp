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
<h1> Welcome, ${user.firstName} ${user.lastName}</h1>
<p>Here are some of the events in your states: </p>
<table>
<tr>
<th> Name </th>
<th> Date </th>
<th> Location </th>
<th> Host </th>
<th> Action/Status</th>
</tr>
<c:forEach items="${stateEvents}" var="stateEvent">
<tr>
<td><a href="/events/${stateEvent.id}">${stateEvent.name}</a></td>
<td>${stateEvent.date}</td>
<td>${stateEvent.location}</td>
<td>${stateEvent.host.firstName} ${stateEvent.host.lastName}</td>

</tr>
</c:forEach>
</table>

<h3> Create Event</h3>
<form:form action="/addEvent" method="post" modelAttribute="event">
<p>
<form:label path="name"> Name</form:label>
<form:input path="name"/>
<form:errors path="name"/>
</p>
<p>
<form:label path="date"> Date</form:label>
<form:input type="date" path="date"/>
<form:errors path="date"/>
</p>
<p>
<form:label path="location">Location</form:label>
<form:input path="location"/>
<form:errors path="location"/>
<form:select path="state">
<c:forEach items="${event.state}" var="state">
<form:option value="${state}">${state}</form:option>
</c:forEach>
</form:select>
<form:errors path="state"/>
</p>

<input type="submit" value="Create"/>
</form:form>
</body>
</html>