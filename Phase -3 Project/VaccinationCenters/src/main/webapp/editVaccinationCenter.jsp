<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Vaccination Center</title>
</head>
<body>

<h2>Edit Vaccination Center</h2>

    <form action="/vaccinationCenter/edit" method="post">
        <input type="hidden" name="id" value="${vaccinationCenter.id}" />
        <label>Name: <input type="text" name="name" value="${vaccinationCenter.name}" /></label><br/>
        <label>City: <input type="text" name="city" value="${vaccinationCenter.city}" /></label><br/>
        <input type="submit" value="Edit Vaccination Center">
    </form>

    <a href="/vaccinationCenters">Back to Vaccination Centers</a>
</body>
</html>