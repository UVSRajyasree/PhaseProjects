package com.servlet;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.LeaderboardEntry;
import java.util.List;
import com.QuizAttemptDAO;
/**
 * Servlet implementation class LeaderBoardServlet
 */
@WebServlet("/leaderboard")
public class LeaderBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaderBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Inside the doGet method of LeaderBoardServlet
		int userId = Integer.parseInt(request.getParameter("userId"));
		int quizId = Integer.parseInt(request.getParameter("quizId"));
		int score = Integer.parseInt(request.getParameter("score"));
		String userName = request.getParameter("userName"); 

	        // Save the user's score to the leaderboard
	        QuizAttemptDAO.saveLeaderboardEntry(userId, userName, quizId, score);


		// Retrieve leaderboard data from the database using QuizAttemptDAO or another relevant DAO
        List<LeaderboardEntry> leaderboard = QuizAttemptDAO.getLeaderboard();

        // Set the leaderboard as an attribute in the request
        request.setAttribute("leaderboard", leaderboard);

        // Forward to the JSP
        request.getRequestDispatcher("leaderboard.jsp").forward(request, response);
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
