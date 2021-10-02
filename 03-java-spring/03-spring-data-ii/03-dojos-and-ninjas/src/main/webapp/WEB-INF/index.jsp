<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<a href="/dojos/new">New Dojo</a>
		<a href="/ninjas/new">New Ninja</a>
		
		<h1>List of Dojos</h1>
		<c:forEach items="${dojos}" var="dojo">
			<a href="/dojos/${dojo.id}">${dojo.name}</a>
			<br>
		</c:forEach>
	</body>
</html>