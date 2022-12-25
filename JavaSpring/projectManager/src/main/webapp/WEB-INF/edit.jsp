<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit My Task</title>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    .container{
        width: 60%;
        margin-top: 5%;
        margin-left: 20%;
        /* border: 1px dotted red; */
    }
    .error{
        color: red;
    }
    table{
        width: 50%;
        margin-bottom: 5%;
    }
    .anchors a, .btn{
        text-decoration: none;
        color: black;
        background-color: white;
        padding: 8%;
        border: 2px solid black;
    }
    .anchors{
        display: flex;
        justify-content: space-between;
        align-items: center;
        width: 20%;
        margin-left: 20%;
        /* border: 1px dotted red; */
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Edit Project</h1>
        <form:form action="/projects/${project.id}/update" method="post" modelAttribute="project">
            <form:input type="hidden" path="leader"></form:input>
            <form:input type="hidden" path="members"></form:input>
            <table>
                <tbody>
                    <tr>
                        <td><form:errors path="title" class="error"></form:errors></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Project Title:</td>
                        <td><form:input path="title"></form:input></td>
                    </tr>
                    <tr>
                        <td><form:errors path="description" class="error"></form:errors></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Project Description:</td>
                        <td><form:textarea path="description"></form:textarea></td>
                    </tr>
                    <tr>
                        <td><form:errors path="dueDate" class="error"></form:errors></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Due Date:</td>
                        <td><form:input type="date" path="dueDate"></form:input></td>
                    </tr>
                </tbody>
            </table>
            <div class="anchors">
                <p><a href="/dashboard">Cancel</a></p>
                <p><input class="btn" type="submit" value="Submit"></p>
            </div>
        </form:form>
    </div>
</body>
</html>