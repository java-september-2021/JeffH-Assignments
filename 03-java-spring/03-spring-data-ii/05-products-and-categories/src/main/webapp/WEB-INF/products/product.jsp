<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1><c:out value="${product.name}"/></h1>
		
		<form:form action="/products/addCatToProd/${product.id}" method="post" modelAttribute="product">
			<p>
				<form:label path="categories">Add Category</form:label>
        		<form:select path="categories">
        			<c:forEach items="${notAddedCategories}" var="notCategory">
						<form:option value="${notCategory.id}" label="${notCategory.name}"/>
					</c:forEach>
        		</form:select>
        		<form:errors path="categories"/>
   			</p>
   			<input type="submit" value="Submit"/>
		</form:form>
		
		<h2>Added Categories</h2>
		<ul>
		<c:forEach items="${ product.categories }" var="cat">
			<li>${ cat.name }</li>			
		</c:forEach>
		</ul>
	</body>
</html>