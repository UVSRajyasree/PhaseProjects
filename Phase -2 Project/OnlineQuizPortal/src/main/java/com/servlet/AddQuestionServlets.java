package com.servlet;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.QuestionDAO;
import com.Question;
/**
 * Servlet implementation class AddQuestionServlets
 */
@WebServlet("/add-question")
public class AddQuestionServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionServlets() {
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
		String questionText = request.getParameter("questionText");
        String option1 = request.getParameter("option1");
        String option2 = request.getParameter("option2");
        String option3 = request.getParameter("option3");
        String option4 = request.getParameter("option4");
        int correctOption = Integer.parseInt(request.getParameter("correctOption"));
        int quizId = Integer.parseInt(request.getParameter("quizId"));

     

        // Add the question
        boolean addSuccess = QuestionDAO.addQuestion(questionText, option1, option2, option3, option4, correctOption);

        if (addSuccess) {
            // Redirect to a success page or admin dashboard
            response.sendRedirect("admin-dashboard.jsp");
        } else {
            // Redirect to the question addition page with an error message
            response.sendRedirect("add-question.jsp?error=1");
        }
	}

}
