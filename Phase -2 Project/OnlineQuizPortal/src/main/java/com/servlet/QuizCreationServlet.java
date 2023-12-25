package com.servlet;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.QuizDAO;
import com.QuestionDAO;
/**
 * Servlet implementation class QuizCreationServlet
 */
@WebServlet("/create-quiz")
public class QuizCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizCreationServlet() {
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
		String quizName = request.getParameter("quizName");

        // You might want to add validation for quizName here

        // Create the quiz
        boolean creationSuccess = QuizDAO.createQuiz(quizName);

        if (creationSuccess) {
            // Redirect to a success page or admin dashboard
            response.sendRedirect("admin-dashboard.jsp");
        } else {
            // Redirect to the creation page with an error message
            response.sendRedirect("create-quiz.jsp?error=1");
        }
    
	}

}
