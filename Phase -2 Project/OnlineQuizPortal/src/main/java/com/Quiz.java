package com;

import com.Question;
public class Quiz {

	private int quizId;
    private String quizName;

    public Quiz(int quizId, String quizName) {
        this.quizId = quizId;
        this.quizName = quizName;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
}
