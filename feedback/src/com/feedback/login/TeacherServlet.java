package com.feedback.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feedback.database.DatabaseConnection;

public class TeacherServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		String user = request.getParameter("username");
		String pass = request.getParameter("pass");
		int id = 0;

		try {
			Connection con = DatabaseConnection.getInstance();
			PreparedStatement st = con
					.prepareStatement("select * from feedback.teacher where userName=? and password=?");
			st.setString(1, user);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				id = rs.getInt("id");
				HttpSession session = request.getSession();
				session.setAttribute("id", id);

				Byte b = rs.getByte("isCoordinator");
				if (b == 1) {
					request.getRequestDispatcher("/Login/coordinatorhome.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/Login/teacherhome.jsp").forward(request, response);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
