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
		<h1>List of Categories</h1>
		<c:forEach items="${categories}" var="category">
			<a href="/categories/${category.id}">${category.name}</a>
			<br>
		</c:forEach>
	</body>
</html>