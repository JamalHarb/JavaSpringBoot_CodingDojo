<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
</head>
<body>
    <div class="container">
        <h1 class="welcome">Book Club</h1>
        <p class="welcome">A place for friends to share thoughts on books.</p>
        <div class="log-reg">
            <div class="reg">
                <h1>Register</h1>
                <form:form action="/register" method="post" modelAttribute="newUser">
                    <table>
                        <tbody>
                            <tr>
                                <td class="left">User Name:</td>
                                <td><form:input path="userName"></form:input></td>
                                <td><form:errors class="error" path="userName"></form:errors></td>
                            </tr>
                            <tr>
                                <td class="left">Email:</td>
                                <td><form:input path="email"></form:input></td>
                                <td><form:errors class="error" path="email"></form:errors></td>
                            </tr>
                            <tr>
                                <td class="left">Password:</td>
                                <td><form:input type="password" path="password"></form:input></td>
                                <td><form:errors class="error" path="password"></form:errors></td>
                            </tr>
                            <tr>
                                <td class="left">Confirm Password:</td>
                                <td><form:input type="password" path="confirm"></form:input></td>
                                <td><form:errors class="error" path="confirm"></form:errors></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td align="right"><input class="btn" type="submit" value="Register"></td>
                            </tr>
                        </tbody>
                    </table>
                </form:form>
            </div>
            <div class="log">
                <h1>Login</h1>
                <form:form action="/login" method="post" modelAttribute="newLogin">
                    <table>
                        <tbody>
                            <tr>
                                <td>Email:</td>
                                <td><form:input path="email"></form:input></td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td><form:input type="password" path="password"></form:input></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td align="right"><input class="btn" type="submit" value="Login"></td>
                            </tr>
                        </tbody>
                    </table>
                    <p><form:errors class="error" path="email"></form:errors></p>
                    <p><form:errors class="error" path="password"></form:errors></p>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>