package com;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.QuizDAO;
import com.Quiz;
import com.Question;

public class QuestionDAO {

	public static boolean addQuestion(String questionText, String option1, String option2, String option3,
            String option4, int correctOption) {
try (Connection connection = DBHelper.getConnection();
PreparedStatement preparedStatement = connection.prepareStatement(
"INSERT INTO questions (question_text, option1, option2, option3, option4, correct_option) " +
   "VALUES (?, ?, ?, ?, ?, ?)")) {

preparedStatement.setString(1, questionText);
preparedStatement.setString(2, option1);
preparedStatement.setString(3, option2);
preparedStatement.setString(4, option3);
preparedStatement.setString(5, option4);
preparedStatement.setInt(6, correctOption);


int rowsAffected = preparedStatement.executeUpdate();

// Check if the insertion was successful
return rowsAffected > 0;

} catch (SQLException e) {
e.printStackTrace();
return false; // Return false if an exception occurs
}
}
	public static List<Question> getQuestionListByQuizId(int quizId) {
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

    public static boolean addQuestionToQuiz(int quizId, int questionId) {
        try (Connection connection = DBHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO quiz_questions (quiz_id, question_id) VALUES (?, ?)")) {

            preparedStatement.setInt(1, quizId);
            preparedStatement.setInt(2, questionId);

            int rowsAffected = preparedStatement.executeUpdate();

            // Check if the insertion was successful
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an exception occurs
        }
    }
    public static List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();

        try (Connection connection = DBHelper.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM questions");
                ResultSet resultSet = preparedStatement.executeQuery()) {

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

           } catch (SQLException e) {
               e.printStackTrace();
           }

           return questionList;
        
    }
}
