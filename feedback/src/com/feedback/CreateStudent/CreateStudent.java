package com.feedback.CreateStudent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feedback.database.DatabaseConnection;
import com.feedback.model.ClassModel;
import com.mysql.cj.Session;

public class CreateStudent extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<ClassModel> classModelList = new ArrayList<>();

		try {
			Connection con = DatabaseConnection.getInstance();
			PreparedStatement st = con.prepareStatement("select * from class");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				// fetching id and name to variables
				int id = rs.getInt("id");
				String name = rs.getString("className");

				// Creating ClassModel Object
				ClassModel classModel = new ClassModel();
				classModel.setId(id);
				classModel.setName(name);

				// Adding ClassModel Object to classModelList
				classModelList.add(classModel);

			}

			request.setAttribute("classList", classModelList);

			request.getRequestDispatcher("/Login/Addnewstudent.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String username = request.getParameter("username").toString();
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String repassword = request.getParameter("repass");
		String branch = request.getParameter("branch");
		String model = request.getParameter("model");
		String regnum = request.getParameter("registernumber");

		try {

			Connection con = DatabaseConnection.getInstance();

			HttpSession session = request.getSession();
			int id = (int) session.getAttribute("id");

			PreparedStatement st = con.prepareStatement("INSERT INTO student "
					+ "( userName, password, rollNo, name, classid, coordinatorid) " + "VALUES ( ?, ?, ?, ?, ?, ?)");
			st.setString(1, username);
			st.setString(2, password);
			st.setString(3, regnum);
			st.setString(4, name);
			st.setString(5, model);
			st.setInt(6, id);
			st.executeUpdate();

			request.setAttribute("successMessage", "Added Student Succefully");
			request.getRequestDispatcher("/Login/coordinatorhome.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
