package com.feedback.teacher;

import java.awt.Window;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.AllocationExpression;

import com.feedback.database.DatabaseConnection;
import com.feedback.model.ClassModel;

public class CreateTeacherServlet extends HttpServlet {

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

			request.getRequestDispatcher("/Login/Addnewteacher.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Boolean isCoordinator=false;
		String username=request.getParameter("username").toString();
		String name=request.getParameter("name");
		String password=request.getParameter("pass");
		String repassword=request.getParameter("repass");
		String branch=request.getParameter("branch");
		String subject=request.getParameter("subject");
		String type=request.getParameter("iscoordinator");
		if( type != null && type.equals("Coordinator"))
				{
					  isCoordinator=true;
				}
		
		String batch=request.getParameter("model");

		
		try {
			
			
			Connection con = DatabaseConnection.getInstance();
			PreparedStatement st = con.prepareStatement("INSERT INTO teacher "
					+ "( userName, password, name, subject, classid, adminid, isCoordinator,isdeleted) "
					+ "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, username);
			st.setString(2, password);
			st.setString(3, name);
			st.setString(4, subject);
			st.setString(5, batch);
			st.setInt(6, 1);
			st.setBoolean(7, isCoordinator);			
			st.setBoolean(8, false);			
			st.executeUpdate();
			
			request.setAttribute("successMessage", "Added Teacher Succefully");
			request.getRequestDispatcher("/AdminHome.jsp").forward(request, response);

			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	
		
		
		
	}

	
}
