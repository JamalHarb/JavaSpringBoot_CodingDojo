<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Project Manager Dashboard</title>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    .container{
        width: 95%;
        margin: 5% auto;
        /* border: 1px dotted red; */
    }
    header{
        display: flex;
        justify-content: space-between;
        align-items: center;
        width: 50%;
        margin-bottom: 5%;
        /* border: 1px dotted red; */
    }
    .main-top{
        display: flex;
        justify-content: space-between;
        align-items: center;
        /* border: 1px dotted red; */
    }
    .main-top p{
        width: 10%;
    }
    a.new-project{
        text-decoration: none;
        color: black;
        padding: 1% 4%;
        border: 2px solid black;
    }
</style>
</head>
<body>
    <div class="container">
        <header>
            <h1>Welcome, ${user.userName}</h1>
            <p><a href="/logout">logout</a></p>
        </header>
        <main>
            <div class="main-top">
                <p>All projects</p>
                <p><a class="new-project" href="/projects/new">+ new project</a></p>
            </div>
            <table class="table table-striped">
                <thead>
                    <tr class="table-secondary">
                        <td>Project</td>
                        <td>Team Lead</td>
                        <td>Due Date</td>
                        <td>Actions</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="project" items="${otherProjects}">
                        <c:if test="${user.id != project.leader.id}">
                            <tr>
                                <td><a href="/projects/${project.id}/show"><c:out value="${project.title}"></c:out></a></td>
                                <td><c:out value="${project.leader.userName}"></c:out></td>
                                <!-- <td><c:out value="${project.dueDate}"></c:out></td> -->
                                <td><fmt:formatDate value="${project.dueDate}" pattern="MMMM, yyyy" /></td>
                                <td><a href="/projects/${project.id}/join">join team</a></td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
            <br><br><br>
            <p>Your projects</p>
            <table class="table table-striped">
                <thead>
                    <tr class="table-secondary">
                        <td>Project</td>
                        <td>Team Lead</td>
                        <td>Due Date</td>
                        <td>Actions</td> 
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="project" items="${myProjects}">
                        <tr>
                            <td><a href="/projects/${project.id}/show"><c:out value="${project.title}"></c:out></a></td>
                            <td><c:out value="${project.leader.userName}"></c:out></td>
                            <!-- <td><c:out value="${project.dueDate}"></c:out></td> -->
                            <td><fmt:formatDate value="${project.dueDate}" pattern="MMMM, yyyy" /></td>
                            <c:choose>
                                <c:when test="${user.id == project.leader.id}">
                                    <td><a href="/projects/${project.id}/edit">edit</a></td>
                                </c:when>
                                <c:otherwise>
                                    <td><a href="/projects/${project.id}/leave">leave team</a></td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>
    </div>
</body>
</html>