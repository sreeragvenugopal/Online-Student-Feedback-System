package com.feedback.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feedback.database.DatabaseConnection;

public class StudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String roll = request.getParameter("rollnum");
		String password = request.getParameter("pass");
		try {
			Connection con = DatabaseConnection.getInstance();
			PreparedStatement st = con.prepareStatement("select * from feedback.student where rollNo=? and password=?");
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				
				request.getRequestDispatcher("/Login/Studenthome.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("Studentlogin.jsp").forward(request, response);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
