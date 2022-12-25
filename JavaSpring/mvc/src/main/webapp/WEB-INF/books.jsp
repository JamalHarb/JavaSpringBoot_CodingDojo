<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
</head>
<body>
    <div class="container">
        <div class="all-books">
            <h1>All Books</h1>
            <table border="2px">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Language</th>
                        <th>Number Of Pages</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td><c:out value="${book.id}"></c:out></td>
                            <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
                            <td><c:out value="${book.description}"></c:out></td>
                            <td><c:out value="${book.language}"></c:out></td>
                            <td><c:out value="${book.numberOfPages}"></c:out></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="add-book">
            <form action="/add_book" method="post">
                <p><label>Title</label><input name="title" type="text"></p>
                <p><label>Description</label><input name="desc" type="text"></p>
                <p><label>Language</label><input name="lang" type="text"></p>
                <p><label>Number of Pages</label><input name="pages" type="text"></p>
                <p><input type="submit" value="Create Book"></p>
            </form>
        </div>
    </div>
</body>
</html>