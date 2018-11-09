package com.feedback.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("vasnnu");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("username"));
		String user=request.getParameter("username");
		String pass = request.getParameter("pass");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback","root","");
			PreparedStatement st = con.prepareStatement("select * from feedback.admin where userName=? and password=?");
			st.setString(1, user);
			st.setString(2, pass);
			
			ResultSet rs=st.executeQuery();

			if(rs.next()) {
			
				request.getRequestDispatcher("/AdminHome.html").forward(request, response);
			}
			else {
				
				request.setAttribute("errorMessage", "Username or Password is wrong");
				request.getRequestDispatcher("Adminlogin.jsp").forward(request, response);
				
			}
			
			
			
			

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//select * from admin where userName=? and password=?;
	}

}
