package com;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	 public static boolean registerUser(String username, String password, String fullName) {
	        try (Connection connection = DBHelper.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "INSERT INTO users (username, password, full_name) VALUES (?, ?, ?)")) {
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);
	            preparedStatement.setString(3, fullName);

	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public static boolean authenticateUser(String username, String password) {
	        try (Connection connection = DBHelper.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(
	                     "SELECT * FROM users WHERE username=? AND password=?")) {
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                return resultSet.next();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
}
