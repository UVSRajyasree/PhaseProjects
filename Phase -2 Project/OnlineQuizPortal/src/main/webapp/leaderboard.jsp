<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.LeaderboardEntry"  %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.QuizAttemptDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Leaderboard</title>
    <!-- Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Custom styles -->
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #007bff;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #dee2e6;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Leaderboard</h1>

    <c:if test="${not empty leaderboard}">
        <table class="table">
            <thead>
            <tr>
                <th>UserId</th>
                <th>Username</th>
                <th>QuizId</th>
                <th>Score</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="entry" items="${leaderboard}">
                <tr>
                    <td>${entry.getUserId()}</td>
                    <td>${entry.getUsername()}</td>
                    <td>${entry.getQuizId()}</td>
                    <td>${entry.getScore()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty leaderboard}">
        <p>No leaderboard entries available.</p>
    </c:if>
</div>

<!-- Bootstrap JS and Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-eMNvyHZZJElz4lsuM6FYaiy1ET8tP3qd/Bu9ifCe1ZnM/HzrZZ5HTv4zbggRMPaL"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+Wy8t+Hhx2NlfQ6xSQ"
        crossorigin="anonymous"></script>
</body>
</html>