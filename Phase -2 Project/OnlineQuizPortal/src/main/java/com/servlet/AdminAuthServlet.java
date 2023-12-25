package com.servlet;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.AdminDAO;

/**
 * Servlet implementation class AdminAuthServlet
 */
@WebServlet("/admin-login")
public class AdminAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAuthServlet() {
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

	        if (AdminDAO.authenticateAdmin(username, password)) {
	            // Set admin session attribute for future authorization
	            //request.getSession().setAttribute("isAdmin", true);
	        	HttpSession session = request.getSession();
	            session.setAttribute("isAdminLoggedIn", true);
	            // Redirect to admin dashboard
	            response.sendRedirect("admin-dashboard.jsp");
	        } else {
	            // Redirect to login page with an error message
	            response.sendRedirect("admin-login.jsp?error=1");
	        }
	}

}
