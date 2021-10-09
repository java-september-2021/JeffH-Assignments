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
		<h1><c:out value="${category.name}"/></h1>
		
		<form:form action="/categories/addProdToCat/${category.id}" method="post" modelAttribute="category">
			<p>
				<form:label path="products">Add Product</form:label>
        		<form:select path="products">
        			<c:forEach items="${notAddedProducts}" var="notProduct">
						<form:option value="${notProduct.id}" label="${notProduct.name}"/>
					</c:forEach>
        		</form:select>
        		<form:errors path="products"/>
   			</p>
   			<input type="submit" value="Submit"/>
		</form:form>
		
		<h2>Added Products</h2>
		<ul>
		<c:forEach items="${ category.products }" var="prod">
			<li>${ prod.name }</li>			
		</c:forEach>
		</ul>
	</body>
</html>