<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <p><a href="/languages/${language.id}/delete">delete</a> | <a href="/languages">dashboard</a></p>
    <form:form action="/languages/${language.id}/update" method="post" modelAttribute="language">
        <table>
            <tbody>
                <tr>
                    <td>Name</td>
                    <td><form:input path="name"></form:input></td>
                    <td><form:errors path="name"/></td>
                </tr>
                <tr>
                    <td>Creator</td>
                    <td><form:input path="creator"></form:input></td>
                    <td><form:errors path="creator"/></td>
                </tr>
                <tr>
                    <td>Current Version</td>
                    <td><form:input type="number" step="0.1" path="currentVersion"></form:input></td>
                    <td><form:errors path="currentVersion"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update"></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </form:form>
</body>
</html>