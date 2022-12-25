<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
    <div class="container">
        <h1 class="welcome">Welcome, ${user.userName}!</h1>
        <p class="welcome">This is your dashboard. Nothing to see here yet.</p>
        <p class="welcome"><a href="/logout">logout</a></p>
    </div>
</body>
</html>