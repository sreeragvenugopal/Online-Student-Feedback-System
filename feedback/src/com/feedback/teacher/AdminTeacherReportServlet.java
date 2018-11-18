package com.feedback.teacher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.feedback.database.DatabaseConnection;
import com.feedback.model.TeacherModel;

public class AdminTeacherReportServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TeacherModel> teacherModelList=new ArrayList<>();
		Connection con;
		try {
			con = DatabaseConnection.getInstance();
			teacherModelList=getTeacherModelList(con);
			req.setAttribute("teacherlist", teacherModelList);
			req.getRequestDispatcher("/Login/teacherselect.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private List<TeacherModel> getTeacherModelList(Connection con) throws SQLException {
		List<TeacherModel> teacherModelList=new ArrayList<>();
		PreparedStatement st = con.prepareStatement("SELECT * FROM teacher ORDER BY id");

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			// fetching id and name and subject to variables
			int id = rs.getInt("id");
			String name = rs.getString("name");

			// Creating ClassModel Object
			TeacherModel teachermodel = new TeacherModel();
			teachermodel.setId(id);
			teachermodel.setName(name);

			// Adding ClassModel Object to classModelList
			teacherModelList.add(teachermodel);

		}
		

		return teacherModelList;
	}
}
