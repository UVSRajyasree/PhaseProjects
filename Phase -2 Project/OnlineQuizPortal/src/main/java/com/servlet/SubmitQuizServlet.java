package com.servlet;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Question;
import com.QuizAttemptDAO;
import com.QuestionDAO;
/**
 * Servlet implementation class SubmitQuizServlet
 */
@WebServlet("/submit-quiz")
public class SubmitQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitQuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Map<Integer, Integer> userAnswers = new HashMap<>();
        List<Question> questionList = (List<Question>) request.getAttribute("questionList");

        for (Question question : QuestionDAO.getAllQuestions()) {
            String paramName = "answer" + question.getId();
            int selectedOption = Integer.parseInt(request.getParameter(paramName));
            userAnswers.put(question.getId(), selectedOption);
        }

        // Validate answers and calculate the score (you need to implement this logic)
        int score = calculateScore(questionList, userAnswers);

        // Store quiz attempt results (you need to implement QuizAttemptDAO)
        int userId = getUserIDFromSessionOrRequest(request);
        int quizId = Integer.parseInt(request.getParameter("quizId"));

        QuizAttemptDAO.saveQuizAttempt(userId, quizId,  score);
        
        request.setAttribute("userId", userId);
        request.setAttribute("quizId", quizId);


        // Set the results in the request attribute for JSP
        request.setAttribute("score", score);
        request.setAttribute("userAnswers", userAnswers);
        
        // Forward the request to the quiz results page
        RequestDispatcher dispatcher = request.getRequestDispatcher("quiz-results.jsp");
        dispatcher.forward(request, response);
    }
	private int calculateScore(List<Question> questionList, Map<Integer, Integer> userAnswers) {
	    int totalScore = 0;

	    for (Question question : QuestionDAO.getAllQuestions()) {
	        int questionId = question.getId();
	        int correctOption = question.getCorrectOption();
	        int userAnswer = userAnswers.getOrDefault(questionId, -1); // Default to -1 if user didn't answer

	        if (userAnswer == correctOption) {
	            // Correct answer, award 100 marks
	            totalScore += 100;
	        }
	        
	    }

	    return totalScore;
	

	}

	private int getUserIDFromSessionOrRequest(HttpServletRequest request) {
	    // Try to retrieve user ID from the session
	    HttpSession session = request.getSession(false); // Do not create a new session if it doesn't exist
	    if (session != null && session.getAttribute("userId") != null) {
	        return (int) session.getAttribute("userId");
	    }

	    // If user ID is not in the session, try to get it from the request parameter
	    String userIdParam = request.getParameter("userId");
	    if (userIdParam != null && !userIdParam.isEmpty()) {
	        try {
	            return Integer.parseInt(userIdParam);
	        } catch (NumberFormatException e) {
	            // Handle the case where the user ID parameter is not a valid integer
	            e.printStackTrace(); // Log the exception or handle it as appropriate
	        }
	    }

	    // If user ID is not found in session or request, return a default or handle as needed
	    return -1; // You may choose a different value or throw an exception
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// Retrieve user's answers from the request
	}
}
