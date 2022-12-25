<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/style.css">
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
</head>
<body>
    <div class="container">
        <div class="gold-balance">
            <p class="your-gold">Your Gold:</p>
            <p class="balance">${gold}</p>
        </div>
        <div class="places">
            <div class="some-place">
                <p class="place-name">Farm</p>
                <p class="worth">(earns 10-20 gold)</p>
                <form action="/process_gold" method="post">
                    <input type="hidden" name="which_place" value="farm">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
            <div class="some-place">
                <p class="place-name">Cave</p>
                <p class="worth">(earns 10-20 gold)</p>
                <form action="/process_gold" method="post">
                    <input type="hidden" name="which_place" value="cave">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
            <div class="some-place">
                <p class="place-name">House</p>
                <p class="worth">(earns 10-20 gold)</p>
                <form action="/process_gold" method="post">
                    <input type="hidden" name="which_place" value="house">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
            <div class="some-place">
                <p class="place-name">Quest</p>
                <p class="worth">(earns/takes 0-50 gold)</p>
                <form action="/process_gold" method="post">
                    <input type="hidden" name="which_place" value="quest">
                    <input type="submit" value="Find Gold!">
                </form>
            </div>
        </div>
        <div class="activities">
            <p>Activities:</p>
            <div class="log">
            	<c:forEach var="log" items="${activity}">
            		<c:if test="${log.contains('earned')}">
            			<p class="earn"><c:out value="${log}"></c:out></p>
            		</c:if>
            		<c:if test="${log.contains('lost')}">
            			<p class="lost"><c:out value="${log}"></c:out></p>
            		</c:if>
            		<c:if test="${!log.contains('earned') && !log.contains('lost')}">
            			<p><c:out value="${log}"></c:out></p>
            		</c:if>
            	</c:forEach>
            </div>
        </div>
        <div class="reset">
            <form action="/reset" method="post">
                <input type="submit" value="Reset All">
            </form>
        </div>
    </div>
</body>
</html>