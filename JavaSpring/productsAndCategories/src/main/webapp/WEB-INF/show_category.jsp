<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${category.name}</title>
</head>
<body>
    <h1>${category.name}</h1>
    <p><a href="/">Home</a></p>
    <hr>
    <h5>Products</h5>
    <ul>
        <c:forEach var="product" items="${category.products}">
            <li><c:out value="${product.name}"></c:out></li>
        </c:forEach>
    </ul>
    <hr>
    <h5>Add Product</h5>
    <form action="/categories/${category.id}/add_product" method="post">
        <select name="products">
            <c:forEach var="product" items="${products}">
                <option value="${product.id}"><c:out value="${product.name}"></c:out></option>
            </c:forEach>
        </select>
        <input type="submit" value="Add">
    </form>
</body>
</html>