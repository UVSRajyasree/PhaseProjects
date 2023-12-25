package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.QuestionDAO;
/**
 * Servlet implementation class AddQuestionToQuizServlet
 */
@WebServlet("/add-question-to-quiz")
public class AddQuestionToQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionToQuizServlet() {
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
		int quizId = Integer.parseInt(request.getParameter("quizId"));
        int questionId = Integer.parseInt(request.getParameter("questionId"));
        

        // Add the question to the quiz
        boolean addSuccess = QuestionDAO.addQuestionToQuiz(quizId, questionId);

        if (addSuccess) {
            // Redirect to a success page or admin dashboard
            response.sendRedirect("admin-dashboard.jsp");
        } else {
            // Redirect to the question addition page with an error message
            response.sendRedirect("add-question-to-quiz.jsp?error=1");
        }
	}

}
