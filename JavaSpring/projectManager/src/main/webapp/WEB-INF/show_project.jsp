<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Details</title>
</head>
<body>
    <p>Project: ${project.title}</p>
    <p>Description: ${project.description}</p>
    <p>Leader: ${project.leader.userName}</p>
    <p>Members</p>
    <table>
        <c:forEach var="member" items="${project.members}">
            <tr>
                <td>Name</td>
                <td>${member.userName}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>