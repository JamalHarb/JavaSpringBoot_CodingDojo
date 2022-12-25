<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>New Ninja</h1>
    <form:form action="/ninjas/create" method="post" modelAttribute="ninja">
        <table>
            <tr>
                <td>Dojo</td>
                <td>
                    <form:select path="dojo">
                        <option value="" selected>-select a dojo-</option>
                        <c:forEach var="dojo" items="${dojos}">
                            <option value="${dojo.id}"><c:out value="${dojo.name}"></c:out></option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>First Name</td>
                <td><form:input path="firstName"></form:input></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><form:input path="lastName"></form:input></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><form:input path="age"></form:input></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create"></td>
            </tr>
        </table>
    </form:form>
</body>
</html>