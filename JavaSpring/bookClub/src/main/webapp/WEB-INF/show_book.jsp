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
    <p>${book.title}</p>
    <p><a href="/books">back to the shelves</a></p>
    <br><br><br>
    <c:choose>
        <c:when test="${user.id != book.uploader.id}">
            <p><span style="color: red;">${book.uploader.userName}</span> read <span style="color: violet;">${book.title}</span> by <span style="color: green;">${book.author}</span></p>
            <p>Here are ${book.uploader.userName}'s thoughts:</p>
        </c:when>
        <c:otherwise>
            <p><span style="color: red;">You</span> read <span style="color: violet;">${book.title}</span> by <span style="color: green;">${book.author}</span></p>
            <p>Here are your thoughts:</p>
        </c:otherwise>
    </c:choose>
    <hr>
    <br>
    <p>${book.thoughts}</p>
    <br>
    <hr>
    <br><br>
    <c:if test="${user.id == book.uploader.id}">
        <p><a href="/books/${book.id}/edit">edit</a> | <a href="/books/${book.id}/delete">delete</a></p>
    </c:if>
</body>
</html>