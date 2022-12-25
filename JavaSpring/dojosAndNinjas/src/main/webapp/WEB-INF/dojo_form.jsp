<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojos/create" method="post" modelAttribute="dojo">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name"></form:input></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Create"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>