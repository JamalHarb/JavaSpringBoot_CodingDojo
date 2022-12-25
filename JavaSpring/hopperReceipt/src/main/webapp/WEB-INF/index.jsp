<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hopper's Receipt</title>
</head>
<body>
	<h1>Customer Name: <c:out value="${name}"></c:out></h1>
	<h4>Item name: <c:out value="${itemName}"></c:out></h4>
	<h4>Price: $<c:out value="${price}"></c:out></h4>
	<h4>Description: <c:out value="${description}"></c:out></h4>
	<h4>Vendor: <c:out value="${vendor}"></c:out></h4>
</body>
</html>