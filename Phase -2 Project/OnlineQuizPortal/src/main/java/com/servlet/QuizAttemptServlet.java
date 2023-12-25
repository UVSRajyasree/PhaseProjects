package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.QuizAttemptDAO;
import com.QuizDAO;
import com.Question;
import java.util.List;


/**
 * Servlet implementation class QuizAttemptServlet
 */
@WebServlet("/quiz-attempt")
public class QuizAttemptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizAttemptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		    
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// Retrieve quiz ID from the request
        int quizId = Integer.parseInt(request.getParameter("quizId"));

        // Fetch questions for the quiz (you should implement QuizDAO and QuestionDAO)
        List<Question> questionList = QuizDAO.getQuestionsForQuiz(quizId);

        // Set the questions in the request attribute for JSP
        request.setAttribute("questionList", questionList);

        // Forward the request to the quiz page
        RequestDispatcher dispatcher = request.getRequestDispatcher("quiz-page.jsp");
        dispatcher.forward(request, response);
		
	}
	

}
