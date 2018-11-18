package com.feedback.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feedback.database.DatabaseConnection;

public class StudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String roll = request.getParameter("rollnum");
		String password = request.getParameter("pass");
		int id=0;
		try {
			Connection con = DatabaseConnection.getInstance();
			PreparedStatement st = con.prepareStatement("select * from feedback.student where rollNo=? and password=?");
			st.setString(1, roll);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				 id = rs.getInt("id");
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				
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
