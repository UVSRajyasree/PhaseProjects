<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.QuizDAO" %>
    <%@ page import="com.Quiz" %>
    <%@ page import="com.QuestionDAO" %>
    <%@ page import="com.Question" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Add Question</title>
    <!-- Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="container mt-4">
    <h1>Add a New Question</h1>

    <!-- Form for adding a new question -->
    <form action="add-question" method="post">
        <div class="form-group">
            <label for="questionText">Question Text:</label>
            <input type="text" class="form-control" id="questionText" name="questionText" required>
        </div>

        <div class="form-group">
            <label for="option1">Option 1:</label>
            <input type="text" class="form-control" id="option1" name="option1" required>
        </div>

        <div class="form-group">
            <label for="option2">Option 2:</label>
            <input type="text" class="form-control" id="option2" name="option2" required>
        </div>

        <div class="form-group">
            <label for="option3">Option 3:</label>
            <input type="text" class="form-control" id="option3" name="option3" required>
        </div>

        <div class="form-group">
            <label for="option4">Option 4:</label>
            <input type="text" class="form-control" id="option4" name="option4" required>
        </div>

        <div class="form-group">
            <label for="correctOption">Correct Option (1-4):</label>
            <input type="number" class="form-control" id="correctOption" name="correctOption" min="1" max="4" required>
        </div>

        <div class="form-group">
            <label for="answer">Answer:</label>
            <input type="text" class="form-control" id="answer" name="answer" required>
        </div>

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

    <a class="mt-3 d-block" href="admin-dashboard.jsp">Back to Admin Dashboard</a>
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