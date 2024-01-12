<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>

<h2>${welcomeMessage}</h2>
    
    <div>
        <h3>Citizens</h3>
        <a href="/citizens">View Citizens</a>
    </div>
    
    <div>
        <h3>Vaccination Centers</h3>
        <a href="/vaccinationCenters">View Vaccination Centers</a>
    </div>

    <div>
        <a href="logout.jsp">Logout</a>
    </div>
</body>
</html>