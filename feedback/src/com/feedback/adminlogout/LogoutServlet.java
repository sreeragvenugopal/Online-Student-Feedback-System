package com.feedback.adminlogout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)  
             throws ServletException, IOException {  
		  request.getRequestDispatcher("/Login/Adminlogin.jsp").include(request, response);		    
		    HttpSession session=request.getSession();  
            session.invalidate(); 
            request.getRequestDispatcher("/index.html").forward(request, response);
	 }
}