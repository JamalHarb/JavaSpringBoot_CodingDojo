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
	<p>You have visited <a href="/">localhost</a> <c:out value="${counter}"></c:out> times.</p>
	<p><a href="/">Test another visit?</a></p>
</body>
</html>