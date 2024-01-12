<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.vc.entity.Citizen" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Citizen</title>
</head>
<body>

<h2>Edit Citizen</h2>

<%
    Citizen citizen = (Citizen) request.getAttribute("citizen");
    if (citizen != null) {
%>

<form action="<%= request.getContextPath() %>/citizens/editing" method="post">
    <input type="hidden" name="id" value="<%= citizen.getId() %>">
    <label>Name:</label>
    <input type="text" name="name" value="<%= citizen.getName() %>"><br>
    <label>City:</label>
    <input type="text" name="city" value="<%= citizen.getCity() %>"><br>
    <label>Number of Doses:</label>
    <input type="text" name="numberOfDoses" value="<%= citizen.getNumberOfDoses() %>"><br>
    <label>Vaccination Status:</label>
    <input type="text" name="vaccinationStatus" value="<%= citizen.getVaccinationStatus() %>"><br>
    <!-- Add other fields as needed -->
    <input type="submit" value="Save">
</form>

<a href="<%= request.getContextPath() %>/admin/citizens">Back to Citizens</a>

<%
    } else {
%>
    <p>Error: Citizen not found.</p>
<%
    }
%>
</body>
</html>