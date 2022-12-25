<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
    <h1>New Product</h1>
    <p><a href="/">Home</a></p>
    <hr>
    <form:form action="/products/create" method="post" modelAttribute="product">
        <table>
            <tr>
                <td>Name</td>
                <td><form:input path="name"></form:input></td>
                <td><form:errors path="name"></form:errors></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><form:input path="description"></form:input></td>
                <td><form:errors path="description"></form:errors></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><form:input path="price"></form:input></td>
                <td><form:errors path="price"></form:errors></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>