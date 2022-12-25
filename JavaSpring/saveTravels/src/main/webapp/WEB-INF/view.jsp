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
    <div class="container">
        <div class="top">
            <h1>Expense Details</h1>
            <a href="/expenses">go back</a>
        </div>
        <div class="details">
            <table>
                <tbody>
                    <tr>
                        <td>Expense Name:</td>
                        <td>${expense.expenseName}</td>
                    </tr>
                    <tr>
                        <td>Expense Description:</td>
                        <td>${expense.description}</td>
                    </tr>
                    <tr>
                        <td>Vendor:</td>
                        <td>${expense.vendor}</td>
                    </tr>
                    <tr>
                        <td>Amount Spent:</td>
                        <td>${expense.amount}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>