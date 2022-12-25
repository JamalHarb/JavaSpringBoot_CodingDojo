<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="home_style.css">
<meta charset="ISO-8859-1">
<title>Read Share</title>
</head>
<body>
    <div class="container">
        <div class="top">
            <div class="top-left">
                <h1>Welcome, ${user.userName}</h1>
                <p>Books from everyone's shelves:</p>
            </div>
            <div class="top-right">
                <p><a href="/logout">logout</a></p>
                <p><a href="/books/new">+ Add a book to my shelf!</a></p>
                <p><a href="/bookmarket">book market</a></p>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
                <tr class="table-secondary">
                    <th>ID</th>
                    <th>Title</th>
                    <th>Author Name</th>
                    <th>Posted By</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td><c:out value="${book.id}"></c:out></td>
                        <td><a href="books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
                        <td><c:out value="${book.author}"></c:out></td>
                        <td><c:out value="${book.uploader.userName}"></c:out></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>