<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.QuizDAO" %>
    <%@ page import="com.Quiz" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Quiz Page</title>
    <!-- Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- Custom styles -->
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }

        h1, h2 {
            text-align: center;
            color: #007bff;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
        }

        ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        li {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Welcome to the Quiz</h1>

    <!-- Form for adding a new quiz -->
    <form action="create-quiz" method="post" class="mb-3">
        <div class="form-group">
            <label for="quizName">Quiz Name:</label>
            <input type="text" class="form-control" id="quizName" name="quizName" required>
        </div>

        <button type="submit" class="btn btn-primary">Create Quiz</button>
    </form>

    <hr>

    <!-- Display quiz list -->
    <h2>Quiz List</h2>
    <ul>
        <% for (Quiz quiz : QuizDAO.getQuizList()) { %>
            <li><a href="quiz.jsp?quizId=<%= quiz.getQuizId() %>"><%= quiz.getQuizName() %></a></li>
        <% } %>
    </ul>

    <!-- Form for adding a new question -->
    <form action="add-question" method="post">
        <div class="form-group">
            <label for="questionText">Question Text:</label>
            <input type="text" class="form-control" id="questionText" name="questionText" required>
        </div>
        <div class="form-group">
            <label for="answer">Answer:</label>
            <input type="text" class="form-control" id="answer" name="answer" required>
        </div>

        <%-- Dropdown for selecting a quiz (Assuming you have a method in QuizDAO to retrieve the quiz list) --%>
        <div class="form-group">
            <label for="quizId">Select Quiz:</label>
            <select class="form-control" id="quizId" name="quizId" required>
                <% for (Quiz quiz : QuizDAO.getQuizList()) { %>
                    <option value="<%= quiz.getQuizId() %>"><%= quiz.getQuizName() %></option>
                <% } %>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Add Question</button>
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