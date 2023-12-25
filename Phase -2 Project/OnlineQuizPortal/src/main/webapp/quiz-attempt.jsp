<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Question" %>
    <%@page import="com.QuizDAO" %>
    <%@page import="com.QuestionDAO" %>
    <%@page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Attempt Quiz</title>
    <!-- Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Custom styles -->
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }

        form {
            max-width: 600px;
            margin: 20px auto;
        }

        p {
            margin-bottom: 10px;
        }

        button {
            display: block;
            margin-top: 20px;
            background-color: #007bff;
            color: #fff;
            padding: 10px;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="container">
    <form action="submit-quiz" method="post">
        <% for (Question question : QuestionDAO.getAllQuestions()) { %>
            <!-- Render each question here -->
            <div class="mb-3">
                <p><%= question.getQuestionText() %></p>

                <!-- Render options (assuming multiple-choice question) -->
                <% for (int i = 1; i <= 4; i++) { %>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="answer<%= question.getId() %>" value="<%= i %>">
                        <label class="form-check-label"><%= question.getCorrectOption() %></label>
                    </div>
                <% } %>

                <!-- Add hidden input to keep track of question ID -->
                <input type="hidden" name="questionId<%= question.getId() %>" value="<%= question.getId() %>">
            </div>
        <% } %>

        <button type="submit" class="btn btn-primary">Submit Quiz</button>
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