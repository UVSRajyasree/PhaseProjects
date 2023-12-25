package com.servlet;

import jakarta.servlet.RequestDispatcher;




import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Quiz;
import com.DBHelper;
import com.Question;
import com.QuizDAO;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import com.QuestionDAO;
/**
 * Servlet implementation class QuestionListServlet
 */
@WebServlet("/question-list")
public class QuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Retrieve the list of questions from the database
        List<Question> questionList = QuestionDAO.getAllQuestions();

        
        // Set the list of questions as an attribute in the request
        request.setAttribute("questionList", questionList);

        // Forward the request to the question-list.jsp page
        RequestDispatcher dispatcher = request.getRequestDispatcher("question-list.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
