<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/css/form.css">
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
    <div class="container">
        <h1>Send an Omikuji!</h1>
        <form action="/show" method="post">
            <p>Pick any number from 5 to 25</p>
            <p><input type="number" name="num" min="5" max="25"></p>
            <p>Enter the name of any city</p>
            <p><input type="text" name="city"></p>
            <p>Enter the name of any real person</p>
            <p><input type="text" name="person"></p>
            <p>Enter professional endeavor or hobby</p>
            <p><input type="text" name="hobby"></p>
            <p>Enter any type of living thing</p>
            <p><input type="text" name="thing"></p>
            <p>Say something nice to someone</p>
            <p><textarea name="say" cols="30" rows="5"></textarea></p>
            <p>Send and show a friend</p>
            <p><input class="submit" type="submit" value="Send"></p>
        </form>
    </div>
</body>
</html>