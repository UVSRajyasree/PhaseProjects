package com;

public class LeaderboardEntry {

	private int userId;
    private String username;
    private int quizId;
    private int score;

    public LeaderboardEntry(int userId, String username, int quizId, int score) {
        this.userId = userId;
        this.username = username;
        this.quizId = quizId;
        this.score = score;
    }

    // Getter and setter methods for each property

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
