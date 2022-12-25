<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <p><a href="/languages">dashboard</a></p>
    <P>${language.name}</P>
    <p>${language.creator}</p>
    <p>${language.currentVersion}</p>
    <p><a href="/languages/${language.id}/delete">delete</a> | <a href="/languages/${language.id}/edit">edit</a></p>
</body>
</html>