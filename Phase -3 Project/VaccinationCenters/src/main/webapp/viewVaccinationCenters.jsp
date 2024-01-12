<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.vc.entity.VaccinationCenter" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaccination Centers</title>
</head>
<body>

 <h2>Vaccination Centers</h2>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>City</th>
            <th>Actions</th>
        </tr>
        <%
    Object obj = request.getAttribute("vaccinationCenters");
    List<VaccinationCenter> listOfVaccinationCenters = (List<VaccinationCenter>) obj;
    Iterator<VaccinationCenter> iterator = listOfVaccinationCenters.iterator();

    while (iterator.hasNext()) {
        VaccinationCenter vaccinationCenter = iterator.next();
%>
        <tr>
            <td><%= vaccinationCenter.getId() %></td>
            <td><%= vaccinationCenter.getName() %></td>
            <td><%= vaccinationCenter.getCity() %></td>
                <td>
                    <a href="/vaccinationCenter/edit/<%= vaccinationCenter.getId() %>">Edit</a>
                    <a href="/delete/<%= vaccinationCenter.getId() %>">Delete</a>
                    <a href="/vaccinationCenters/<%= vaccinationCenter.getId() %>">View</a>
                     <a href="/vaccinationCenters1/<%= vaccinationCenter.getId() %>">|View Details Of Vaccination Center And Citizens In That Vaccination </a>
                </td>
            </tr>
        <% } %>
    </table>
    <a href="/add">Add Vaccination Center</a>
</body>
</html>