<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Home Page</title>
	</head>
	<body>
		<div class="box">
                <form action="/results" method="POST" class="grid">
                    <label for="name">Your Name</label>
                    <input type="text" name="name" id="name" required>
                    
                    <label for="dojo">Dojo Location</label>
                    <select id="dojo" name="dojo">
						<option value="San Jose">San Jose</option>
						<option value="Chicago">Chicago</option>
						<option value="Houston">Houston</option>
						<option value="Tulsa">Tulsa</option>
					</select>
                    
                    <label for="language">Favorite Language</label>
                    <select id="language" name="language">
						<option value="Python">Python</option>
						<option value="Java">Java</option>
						<option value="C">C</option>
						<option value="Html">Html</option>
					</select>
                    
                    <label for="comments">Comments (optional)</label>
                    <textarea id="comments" name="comments" rows="5" cols="30"></textarea>

                    <input type="submit" value ="Submit" class="btn">
                </form>
		</div>
	</body>
</html>