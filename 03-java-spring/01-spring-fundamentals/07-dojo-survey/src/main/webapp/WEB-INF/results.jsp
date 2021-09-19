<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Results</title>
	</head>
	<body>
		<div class="box">
			<h1>Submitted Results</h1>
			<p class="title">Name</p>
			<p><c:out value="${name}"/></p>
			<p class="title">Dojo Location</p>
			<p><c:out value="${dojo}"/></p>
			<p class="title">Favorite Language</p>
			<p><c:out value="${language}"/></p>
			<p class="title">Comments</p>
			<p><c:out value="${comments}"/></p>
			
			<a href="/">Go Back</a>
		</div>
	</body>
</html>