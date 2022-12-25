<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Edit Expense</title>
</head>
<body>
    <div class="container">
        <div class="top">
            <h1>Edit Expense</h1>
            <a href="/expenses">go back</a>
        </div>
        <div class="edit">
            <form:form action="/expenses/edit/${expense.id}/update" method="post" modelAttribute="expense">
                <p>
                    <form:label path="expenseName">Expense Name</form:label>
                    <form:input path="expenseName"></form:input>
                    <form:errors class="error" path="expenseName"/>
                </p>
                <p>
                    <form:label path="vendor">Vendor</form:label>
                    <form:input path="vendor"></form:input>
                    <form:errors class="error" path="vendor"/>
                </p>
                <p>
                    <form:label path="amount">Amount</form:label>
                    <form:input path="amount"></form:input>
                    <form:errors class="error" path="amount"/>
                </p>
                <p>
                    <form:label path="description">Description</form:label>
                    <form:input path="description"></form:input>
                    <form:errors class="error" path="description"/>
                </p>
                <input type="submit" value="Submit">
            </form:form>
        </div>
    </div>
</body>
</html>