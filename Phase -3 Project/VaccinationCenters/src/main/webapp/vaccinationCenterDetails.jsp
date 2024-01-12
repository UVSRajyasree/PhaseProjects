<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.vc.entity.VaccinationCenter" %>
    <%@page import="com.vc.entity.Citizen" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.Map" %>
    <%@ page import="java.util.HashMap" %>
    <%@ page import="java.util.Iterator" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaccination Center Details</title>
</head>
<body>

<h2>Vaccination Center Details</h2>

<%
    VaccinationCenter vaccinationCenter = (VaccinationCenter) request.getAttribute("vaccinationCenter");
%>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>City</th>
        <!-- Add other fields as needed -->
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><%= vaccinationCenter.getId() %></td>
        <td><%= vaccinationCenter.getName() %></td>
        <td><%= vaccinationCenter.getCity() %></td>
    </tr>
    </tbody>
</table>

<h2>Citizens In This Vaccination Center</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>City</th>
    </tr>
    </thead>
    <tbody>
 <%
 List<Citizen> citizensInVaccinationCenter = (List<Citizen>)  request.getAttribute("citizensInVaccinationCenter");
%>   
    <% for (Citizen citizen : citizensInVaccinationCenter) { %>
        <tr>
            <td><%= citizen.getId() %></td>
            <td><%= citizen.getName() %></td>
            <td><%= citizen.getCity() %></td>
        </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>