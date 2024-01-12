<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Citizen</title>
</head>
<body>

<h2>Add Citizen</h2>

    <form action="/adding" method="post">
        <label>Name: <input type="text" name="name" /></label><br/>
        <label>City: <input type="text" name="city" /></label><br/>
        <label>Number of Doses: <input type="text" name="numberofdoses" /></label><br/>
        <input type="submit" value="Add Citizen">
        </form>
</body>
</html>