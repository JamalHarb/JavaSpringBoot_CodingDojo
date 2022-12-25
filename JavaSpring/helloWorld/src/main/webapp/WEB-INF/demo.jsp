<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello World</title>
</head>
<body>
	<h1>Hello World</h1>
	<%for(int i = 1; i <= 5; i++) { %>
		<p><%= i %></p>
	<%} %>
	<p>The date is <%= new Date() %></p>
</body>
</html>