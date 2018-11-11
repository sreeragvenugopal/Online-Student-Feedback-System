package com.feedback.teacher;

import java.io.IOException;
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

import com.feedback.model.ClassModel;
import com.feedback.model.TeacherModel;

/**
 * Servlet implementation class RemoveTeacher
 */
@WebServlet("/RemoveTeacher")
public class RemoveTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<TeacherModel> TeacherList = new ArrayList<>();
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback", "root", "root");
			PreparedStatement st = con.prepareStatement("SELECT * FROM teachers ORDER BY id");

			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				// fetching id and name and subject to variables
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String subject = rs.getString("subject");

				// Creating ClassModel Object
				 TeacherModel teachermodel = new TeacherModel();
				teachermodel.setId(id);
				teachermodel.setName(name);
				teachermodel.setSubject(subject);

				// Adding ClassModel Object to classModelList
			TeacherList.add(teachermodel);
			
	}
			request.setAttribute("teacherList", TeacherList);
		}
		catch(Exception e){
			System.out.println(e.getMessage());		}

			}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String name = request.getParameter("username");
		String branch = request.getParameter("branch");
		String teacher = request.getParameter("teachers");
		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback","root","root");
			PreparedStatement st = con.prepareStatement("DELETE * FROM teacher  WHERE userName = "+name+"");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
	}

}
