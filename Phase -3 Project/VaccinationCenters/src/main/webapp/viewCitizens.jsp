<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <%@page import="com.vc.entity.Citizen" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Citizens List</title>
</head>
<body>

<h2>Citizens List</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>City</th>
        <th>Number of Doses</th>
        <th>Vaccination Status</th>
        <th>Vaccination Center</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
        <% List<Citizen> citizens = (List<Citizen>) request.getAttribute("citizens");
           for (Citizen citizen : citizens) { %>
            <tr>
                <td><%= citizen.getId() %></td>
                <td><%= citizen.getName() %></td>
                <td><%= citizen.getCity() %></td>
                <td><%= citizen.getNumberOfDoses() %></td>
                <td><%= citizen.getVaccinationStatus() %></td>
                <td><%= (citizen.getVaccinationCenter() != null) ? citizen.getVaccinationCenter().getId() : "Not Mapped" %></td>
                <td>
                    <a href="<%= request.getContextPath() %>/citizens/editing/<%= citizen.getId() %>">Edit</a>
                    |
                    <a href="<%= request.getContextPath() %>/citizens/deleting/<%= citizen.getId() %>">Delete</a>
                    |
                     <a href="<%= request.getContextPath() %>/citizens/<%= citizen.getId() %>">View Details</a>
                </td>
            </tr>
        <% } %>
    </tbody>
</table>

<a href="/adding">Add Citizen</a>
</body>
</html>