package com;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.LeaderboardEntry;

public class QuizAttemptDAO {

	public static boolean saveQuizAttempt(int userId, int quizId, int score) {
        boolean success = false;
        String sql = "INSERT INTO quiz_attempts (user_id, quiz_id, score) VALUES (?, ?, ?)";

        try (Connection connection = DBHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, quizId);
            preparedStatement.setInt(3, score);

            int rowsAffected = preparedStatement.executeUpdate();
            success = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
	}
	 public static List<LeaderboardEntry> getLeaderboard() {
	        List<LeaderboardEntry> leaderboard = new ArrayList<>();

	        try (Connection connection = DBHelper.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "SELECT username, score FROM quiz_attempts ORDER BY score DESC LIMIT 10")) {

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                while (resultSet.next()) {
	                	int userId = resultSet.getInt("userId");
	                    String username = resultSet.getString("username");
	                    int quizId = resultSet.getInt("quizId");
	                    int score = resultSet.getInt("score");
	                   

	                    LeaderboardEntry entry = new LeaderboardEntry(userId, username, quizId, score);
	                    leaderboard.add(entry);
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return leaderboard;
	    }
	 public static void saveLeaderboardEntry(int userId, String userName, int quizId, int score) {
		 PreparedStatement preparedStatement = null;

	        try {
	        	Connection connection = DBHelper.getConnection();

	            String sql = "INSERT INTO leaderboard (user_id, user_name, quiz_id, score) VALUES (?, ?, ?, ?)";
	            
	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, userId);
	            preparedStatement.setString(2, userName);
	            preparedStatement.setInt(3, quizId);
	            preparedStatement.setInt(4, score);

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        } 
	    }
	 
}
