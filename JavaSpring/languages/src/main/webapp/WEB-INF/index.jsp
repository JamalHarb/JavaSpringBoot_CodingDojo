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
    <table border="1px">
        <thead>
            <tr>
                <td>Name</td>
                <td>Creator</td>
                <td>Current Version</td>
                <td>actions</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="language" items="${languages}">
                <tr>
                    <td><a href="/languages/${language.id}"><c:out value="${language.name}"></c:out></a></td>
                    <td><c:out value="${language.creator}"></c:out></td>
                    <td><c:out value="${language.currentVersion}"></c:out></td>
                    <td><a href="/languages/${language.id}/delete">delete</a> | <a href="/languages/${language.id}/edit">edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br><br>
    <form:form action="/languages/create" method="post" modelAttribute="language">
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
                    <td><input type="submit" value="Submit"></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </form:form>
</body>
</html>