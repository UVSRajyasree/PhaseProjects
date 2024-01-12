<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.vc.entity.VaccinationCenter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaccination Center Details</title>
</head>
<body>

<h2>Vaccination Center Details</h2>

<h2>Vaccination Center Details</h2>

<%
    VaccinationCenter vaccinationCenter = (VaccinationCenter) request.getAttribute("vaccinationCenter");
    if (vaccinationCenter != null) {
%>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>City</th>
        </tr>
        <tr>
            <td><%= vaccinationCenter.getId() %></td>
            <td><%= vaccinationCenter.getName() %></td>
            <td><%= vaccinationCenter.getCity() %></td>
        </tr>
    </table>
<%
    } else {
%>
    <p>No vaccination center found with the given ID.</p>
<%
    }
%>

<a href="<%= request.getContextPath() %>/admin/vaccinationCenters">Back to Vaccination Centers</a>

</body>
</body>
</html>