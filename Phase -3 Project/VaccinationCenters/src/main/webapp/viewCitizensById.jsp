<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.vc.entity.Citizen" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Citizens Details</title>
</head>
<body>

<h2>Citizen Details</h2>

<%
    Citizen citizen = (Citizen) request.getAttribute("citizen");
    if (citizen != null) {
%>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>City</th>
            <th>Number of Doses</th>
            <th>Vaccination Status</th>
            <th>Vaccination Center</th>
        </tr>
        <tr>
            <td><%= citizen.getId() %></td>
            <td><%= citizen.getName() %></td>
            <td><%= citizen.getCity() %></td>
            <td><%= citizen.getNumberOfDoses() %></td>
            <td><%= citizen.getVaccinationStatus() %></td>
            <td><%= citizen.getVaccinationCenter() != null ? citizen.getVaccinationCenter().getName() : "N/A" %></td>
        </tr>
    </table>
<%
    } else {
%>
    <p>No citizen found with the given ID.</p>
<%
    }
%>

<a href="<%= request.getContextPath() %>/admin/citizens">Back to Citizens</a>

</body>
</body>
</html>