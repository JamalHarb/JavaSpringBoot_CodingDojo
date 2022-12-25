<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="ISO-8859-1">
<title>Date</title>
</head>
<body>
<div class="container">
		<p class="date"><c:out value="${date}"></c:out></p>
	</div>
	
	<script src="/js/date.js"></script>
</body>
</html>