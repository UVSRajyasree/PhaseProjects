<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<h2>Login</h2>
    <form action="/login" method="post">
        <label>Username: <input type="text" name="username" /></label><br/>
        <label>Password: <input type="password" name="password" /></label><br/>
        <input type="submit" value="Login">  <input type="submit" value="Registration">
    </form>
    <p style="color: red">${error}</p>
</body>
</html>