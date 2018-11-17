package com.feedback.changetpassword;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feedback.database.DatabaseConnection;

public class ChangeTPassword extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String password = request.getParameter("currentpass");
		String newpass = request.getParameter("newpass");
		String confirm = request.getParameter("cnfrmpass");

		try {

			Connection con = DatabaseConnection.getInstance();
			PreparedStatement st = con.prepareStatement("select * from teacher");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String usrname = rs.getString("userName");
				String passwd = rs.getString("password");
				if (passwd.equals(password)) {

					if (confirm.equals(newpass)) {

						PreparedStatement st1 = con.prepareStatement(
								"update teacher set password='" + newpass + "' where userName='" + usrname + "'");
						 st1.executeUpdate();
						 request.setAttribute("infoMessage", "PASSWORD CHANGED");
						request.getRequestDispatcher("/Login/teacherhome.jsp").forward(request, response);

					} else {
						 //request.setAttribute("infoMessage", "Enter Valid Password");
						 //request.getRequestDispatcher("/Login/changeteacherpassword.jsp").forward(request, response);
					}
				}
				else {
					 request.setAttribute("infoMessage", "Enter Valid Password");
					 request.getRequestDispatcher("/Login/changeteacherpassword.jsp").forward(request, response);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
