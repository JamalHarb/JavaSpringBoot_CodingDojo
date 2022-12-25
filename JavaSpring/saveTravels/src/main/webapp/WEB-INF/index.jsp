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
<title>Travel Expenses</title>
</head>
<body>
    <div class="container">
        <div class="expenses">
            <h1>Save Travels</h1>
            <table border="1px">
                <thead>
                    <tr>
                        <th>Expense</th>
                        <th>Vendor</th>
                        <th>Amount</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="expense" items="${expenses}">
                        <tr>
                            <td><a href="/expenses/view/${expense.id}"><c:out value="${expense.expenseName}"></c:out></a></td>
                            <td><c:out value="${expense.vendor}"></c:out></td>
                            <td><c:out value="${expense.amount}"></c:out></td>
                            <td><a href="/expenses/edit/${expense.id}">edit</a> | <a href="/expenses/delete/${expense.id}">delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="add-expense">
            <h2>Add an Expense:</h2>
            <form:form action="/expenses/add" method="post" modelAttribute="expense">
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