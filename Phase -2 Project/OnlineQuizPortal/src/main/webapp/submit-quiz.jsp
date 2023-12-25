<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Question" %>
    <%@ page import="java.util.List" %>
    <%@ page import="java.util.Map" %>
    <%@page import="com.QuestionDAO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Quiz Submission Results</title>
    <!-- Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Custom styles -->
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }

        h1 {
            color: #007bff;
        }

        p {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        p.score {
            color: #28a745;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Quiz Submission Results</h1>
    <p class="score">Your Score: <%= request.getAttribute("score") %></p>
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