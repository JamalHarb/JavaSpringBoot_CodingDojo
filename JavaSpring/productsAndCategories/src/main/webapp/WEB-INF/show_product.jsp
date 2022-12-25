<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${product.name}</title>
</head>
<body>
    <h1>${product.name}</h1>
    <p><a href="/">Home</a></p>
    <hr>
    <h5>Categories</h5>
    <ul>
        <c:forEach var="category" items="${product.categories}">
            <li><c:out value="${category.name}"></c:out></li>
        </c:forEach>
    </ul>
    <hr>
    <h5>Add Category</h5>
    <form action="/products/${product.id}/add_category" method="post">
        <select name="categories">
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}"><c:out value="${category.name}"></c:out></option>
            </c:forEach>
        </select>
        <input type="submit" value="Add">
    </form>
</body>
</html>