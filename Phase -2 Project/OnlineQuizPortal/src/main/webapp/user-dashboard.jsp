<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="java.util.List" %>
  <%@ page import="com.Quiz" %>
  <%@ page import="com.QuizAttemptDAO" %>
  <%@ page import="com.LeaderboardEntry" %>
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="com.QuizDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>User Dashboard</title>
    <!-- Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Custom styles -->
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }

        h1, h2 {
            color: #007bff;
        }

        table {
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        form {
            display: inline;
        }

        a {
            display: block;
            margin-top: 20px;
            color: #007bff;
        }

        input[type="submit"] {
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Welcome to Your User Dashboard</h1>
    <p>Account Created Successfully</p>

    <h2>Available Quizzes:</h2>

    <table class="table table-bordered">
        <thead class="thead-dark">
            <tr>
                <th>Quiz ID</th>
                <th>Quiz Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% for (Quiz quiz : QuizDAO.getQuizList()) { %>
                <tr>
                    <td><%= quiz.getQuizId() %></td>
                    <td><%= quiz.getQuizName() %></td>
                    <td>
                        <form action="quiz-attempt" method="post">
                            <input type="hidden" name="quizId" value="<%= quiz.getQuizId() %>">
                            <input type="submit" class="btn btn-primary" value="Start">
                        </form>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <a href="leaderboard.jsp" class="btn btn-info">LeaderBoard</a>

    <form action="logout" method="post">
        <input type="submit" class="btn btn-danger" value="Logout">
    </form>
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
