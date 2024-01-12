<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Vaccination Centers</title>
</head>
<body>

<h2>Add Vaccination Center</h2>

    <form action="/add" method="post">
        <label>Name: <input type="text" name="name" /></label><br/>
        <label>City: <input type="text" name="city" /></label><br/>
        <input type="submit" value="Add Vaccination Center">
    </form>

    <a href="/vaccinationCenters">Back to Vaccination Centers</a>
</body>
</html>