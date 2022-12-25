<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Book Lender Dashboard</title>
</head>
<body>
    <div class="container">
        <header>
            <div class="left">
                <p>Hello, ${user.userName}. Welcome to..</p>
                <h1>The Book Broker!</h1>
            </div>
            <div class="right">
                <p><a href="/books">back to the shelves</a></p>
            </div>
        </header>
        <div class="available">
            <p>Available books to borrow</p>
            <table class="table table-striped">
                <thead>
                    <tr class="table-secondary">
                        <td>ID</td>
                        <td>Title</td>
                        <td>Author Name</td>
                        <td>Owner</td>
                        <td>Actions</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${notBorrowedBooks}">
                        <tr>
                            <td><c:out value="${book.id}"></c:out></td>
                            <td><c:out value="${book.title}"></c:out></td>
                            <td><c:out value="${book.author}"></c:out></td>
                            <td><c:out value="${book.uploader.userName}"></c:out></td>
                            <c:choose>
                                <c:when test="${user.id != book.uploader.id}">
                                    <td><a href="/bookmarket/borrow/${book.id}">borrow</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td><a href="/books/${book.id}/edit">edit</a> | <a href="/books/${book.id}/delete">delete</a></td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="borrowed">
            <p>Books I'm borrowing</p>
            <table class="table table-striped">
                <thead>
                    <tr class="table-secondary">
                        <td>ID</td>
                        <td>Title</td>
                        <td>Author Name</td>
                        <td>Owner</td>
                        <td>Actions</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${borrowedBooks}">
                        <tr>
                            <td><c:out value="${book.id}"></c:out></td>
                            <td><c:out value="${book.title}"></c:out></td>
                            <td><c:out value="${book.author}"></c:out></td>
                            <td><c:out value="${book.uploader.userName}"></c:out></td>
                            <td><a href="/bookmarket/unborrow/${book.id}">return</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>