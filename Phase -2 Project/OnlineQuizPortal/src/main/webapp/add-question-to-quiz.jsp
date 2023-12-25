<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Quiz" %>
    <%@ page import="com.QuizDAO" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Question to Quiz</title>
    <!-- Bootstrap CSS link -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<%
    // Retrieve the list of quizzes to select one for adding the question
    List<Quiz> quizList = QuizDAO.getQuizList();
%>

<div class="container mt-5">
    <h2>Select a Quiz to Add Question:</h2>
    <form action="add-question-to-quiz" method="post">
        <div class="form-group">
            <label for="quizId">Select Quiz:</label>
            <select class="form-control" name="quizId" id="quizId">
                <% for (Quiz quiz : quizList) { %>
                    <option value="<%= quiz.getQuizId() %>"><%= quiz.getQuizName() %></option>
                <% } %>
            </select>
        </div>

        <h2>Question Details:</h2>
        <div class="form-group">
            <label for="questionText">Question Text:</label>
            <input type="text" class="form-control" name="questionText" required>
        </div>
        <div class="form-group">
            <label for="option1">Option 1:</label>
            <input type="text" class="form-control" name="option1" required>
        </div>
        <div class="form-group">
            <label for="option2">Option 2:</label>
            <input type="text" class="form-control" name="option2" required>
        </div>
        <div class="form-group">
            <label for="option3">Option 3:</label>
            <input type="text" class="form-control" name="option3" required>
        </div>
        <div class="form-group">
            <label for="option4">Option 4:</label>
            <input type="text" class="form-control" name="option4" required>
        </div>
        <div class="form-group">
            <label for="correctOption">Correct Option:</label>
            <input type="number" class="form-control" name="correctOption" required>
        </div>

        <button type="submit" class="btn btn-primary">Add Question</button>
    </form>
</div>

<!-- Bootstrap JS and Popper.js CDN links (required for Bootstrap JavaScript components) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>