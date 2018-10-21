package com.feedback.teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feedback.model.ClassModel;

public class CreateTeacherServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<ClassModel> classModelList = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback","root","root");
			PreparedStatement st = con.prepareStatement("select * from class");

			ResultSet rs=st.executeQuery();

			while(rs.next()) {
				//fetching id and name to variables
				int id = rs.getInt("id");
				String name = rs.getString("className");
				
				//Creating ClassModel Object
				ClassModel classModel = new ClassModel();
				classModel.setId(id);
				classModel.setName(name);
				
				//Adding ClassModel Object to classModelList
				classModelList.add(classModel);
				
				
			}
			
			request.setAttribute("classList", classModelList);
			
			request.getRequestDispatcher("/Login/Addnewteacher.jsp").forward(request, response);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		String username=request.getParameter("username");
		String name=request.getParameter("name");
		String password=request.getParameter("pass");
		String branch=request.getParameter("");
	
		
		
		
	}
}
