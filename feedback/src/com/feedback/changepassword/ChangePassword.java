package com.feedback.changepassword;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;

import com.feedback.database.DatabaseConnection;
import javax.swing.JOptionPane;

public class ChangePassword extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		int id=(int) session.getAttribute("id");
		
		String password = request.getParameter("currentpass");
		String newpass = request.getParameter("newpass");
		String confirm = request.getParameter("cnfrmpass");

		try {

			Connection con = DatabaseConnection.getInstance();
			PreparedStatement st = con.prepareStatement("select * from teacher where id="+id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String passwrd = rs.getString("password");
				String uname = rs.getString("userName");
				if (password.equals(passwrd)) {
					if (newpass.equals(confirm)) {
						PreparedStatement ps = con.prepareStatement(
								"update teacher set password='" + newpass + "' where userName='" + uname + "'");
						ps.executeUpdate();
						request.setAttribute("infoMessage", "PASSWORD CHANGED");
						RequestDispatcher rd = request.getRequestDispatcher("/Login/coordinatorhome.jsp");
						rd.forward(request, response);
						return;

					} else {
						request.setAttribute("infoMessage", "New Password and Confirm  Password is not matching");
						request.getRequestDispatcher("/Login/changeteacherpassword.jsp").forward(request, response);

					}
				} else {
					request.setAttribute("infoMessage", "Old Password Dosent Match");
					request.getRequestDispatcher("/Login/changeteacherpassword.jsp").forward(request, response);

				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
