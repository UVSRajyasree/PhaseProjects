package com.servlet;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.UserDAO;
/**
 * Servlet implementation class UserAuthenticationServlet
 */
@WebServlet("/register")
public class UserAuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAuthenticationServlet() {
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
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");

        
        boolean registrationSuccess = UserDAO.registerUser(username, password, fullName);



//        if (UserDAO.authenticateUser(username, password)) {
//            // Set user session attribute for future authorization
//            request.getSession().setAttribute("isUser", true);
//            // Redirect to user dashboard or home page
        if (UserDAO.authenticateUser(username, password)) {
            // User already exists, forward to login page with a message
            request.setAttribute("message", "Username already exists. Please login.");
            response.sendRedirect("user-dashboard.jsp");
        } else {
            // Redirect to login page with an error message
            response.sendRedirect("register.jsp?error=1");
        }
    }
	

}
