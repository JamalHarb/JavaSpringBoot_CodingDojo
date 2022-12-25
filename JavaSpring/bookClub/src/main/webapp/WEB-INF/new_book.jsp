<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Share</title>
</head>
<body>
    <div class="container">
        <p><a href="/books">back to the shelves</a></p>
        <h1>Add a Book to Your Shelf!</h1>
        <form:form action="/books/create" method="post" modelAttribute="book">
            <form:input type="hidden" path="uploader" value="${user.id}"></form:input>
            <table>
                <tbody>
                    <tr>
                        <td></td>
                        <td><form:errors path="title"></form:errors></td>
                    </tr>
                    <tr>
                        <td>Title</td>
                        <td><form:input path="title"></form:input></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><form:errors path="author"></form:errors></td>
                    </tr>
                    <tr>
                        <td>Author</td>
                        <td><form:input path="author"></form:input></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><form:errors path="thoughts"></form:errors></td>
                    </tr>
                    <tr>
                        <td>My thoughts</td>
                        <td><form:input path="thoughts"></form:input></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="right"><input type="submit" value="Submit"></td>
                    </tr>
                </tbody>
            </table>
        </form:form>
    </div>
</body>
</html>