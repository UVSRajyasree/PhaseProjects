package com;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import com.Quiz;
import com.Question;

public class QuizDAO {
	
	public static boolean createQuiz(String quizName) {
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO quizzes (quiz_name) VALUES (?)")) {

            preparedStatement.setString(1, quizName);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	}
	public static List<Quiz> getQuizList() {
        List<Quiz> quizList = new ArrayList<>();

        try (Connection connection = DBHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM quizzes");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int quizId = resultSet.getInt("quiz_id");
                String quizName = resultSet.getString("quiz_name");

                // Assuming you have a Quiz class with appropriate constructor
                Quiz quiz = new Quiz(quizId, quizName);
                quizList.add(quiz);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quizList;
    }
	 public static List<Question> getQuestionsForQuiz(int quizId) {
	        List<Question> questionList = new ArrayList<>();

	        try (Connection connection = DBHelper.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "SELECT q.* FROM questions q " +
	                             "JOIN quiz_questions qq ON q.question_id = qq.question_id " +
	                             "WHERE qq.quiz_id = ?")) {

	            preparedStatement.setInt(1, quizId);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    int questionId = resultSet.getInt("question_id");
	                    String questionText = resultSet.getString("question_text");
	                    String option1 = resultSet.getString("option1");
	                    String option2 = resultSet.getString("option2");
	                    String option3 = resultSet.getString("option3");
	                    String option4 = resultSet.getString("option4");
	                    int correctOption = resultSet.getInt("correct_option");

	                    Question question = new Question(questionId, questionText, option1, option2, option3, option4, correctOption);
	                    questionList.add(question);
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return questionList;
	    }
	 public static Map<Quiz, List<Question>> getQuizzesWithQuestions() {
	        Map<Quiz, List<Question>> quizzesWithQuestions = new HashMap<>();

	        try (Connection connection = DBHelper.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "SELECT qz.quiz_id, qz.quiz_name, qq.question_id, qq.question_text, qq.option1, qq.option2, qq.option3, qq.option4, qq.correct_option " +
	                             "FROM quizzes qz " +
	                             "JOIN quiz_questions qq ON qz.quiz_id = qq.quiz_id " +
	                             "JOIN questions q ON qq.question_id = q.question_id")) {

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                    int quizId = resultSet.getInt("quiz_id");
	                    String quizName = resultSet.getString("quiz_name");
	                    int questionId = resultSet.getInt("question_id");
	                    String questionText = resultSet.getString("question_text");
	                    String option1 = resultSet.getString("option1");
	                    String option2 = resultSet.getString("option2");
	                    String option3 = resultSet.getString("option3");
	                    String option4 = resultSet.getString("option4");
	                    int correctOption = resultSet.getInt("correct_option");

	                    Quiz quiz = new Quiz(quizId, quizName);
	                    Question question = new Question(questionId, questionText, option1, option2, option3, option4, correctOption);

	                    // Add quiz to the map if not present
	                    quizzesWithQuestions.computeIfAbsent(quiz, k -> new ArrayList<>()).add(question);
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return quizzesWithQuestions;
	    }
	 public static Question getQuizQuestion(int quizId, int questionId) {
	        Question question = null;

	        try (Connection connection = DBHelper.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "SELECT * FROM questions q " +
	                             "JOIN quiz_questions qq ON q.question_id = qq.question_id " +
	                             "WHERE qq.quiz_id = ? AND q.question_id = ?")) {

	            preparedStatement.setInt(1, quizId);
	            preparedStatement.setInt(2, questionId);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    // Retrieve question details from the result set
	                    String questionText = resultSet.getString("question_text");
	                    String option1 = resultSet.getString("option1");
	                    String option2 = resultSet.getString("option2");
	                    String option3 = resultSet.getString("option3");
	                    String option4 = resultSet.getString("option4");
	                    int correctOption = resultSet.getInt("correct_option");

	                    // Create a Question object
	                    question = new Question(questionId, questionText, option1, option2, option3, option4, correctOption);
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle the exception as needed
	        }

	        return question;
	    }
}
