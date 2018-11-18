package com.feedback.teacher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feedback.database.DatabaseConnection;
import com.feedback.model.TeacherModel;

public class GenerateTeacherReportServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<Integer,String> questionIdMap = new HashMap<>();
		Map<String, Long> outputReportMap = new LinkedHashMap<>();
		try {
			HttpSession session = req.getSession();
			int teacherId = (int) session.getAttribute("id");
			Connection con = DatabaseConnection.getInstance();
			PreparedStatement st = con.prepareStatement("select id,questionText  from question;");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String qText = rs.getString("questionText");
				
				questionIdMap.put(id, qText);
			}
			
			st = con.prepareStatement("select questionid,avg(mark) mark from feedback where teacherid=? group by questionid order by questionid;");
			st.setInt(1, teacherId);
			rs = st.executeQuery();
			
			while(rs.next()) {
				int qid = rs.getInt("questionid");
				double mark = rs.getDouble("mark");
				
				outputReportMap.put(questionIdMap.get(qid), Math.round(mark));
			}
			
			req.setAttribute("outputReportMap", outputReportMap);
			req.getRequestDispatcher("/Login/Teacherreport.jsp").forward(req, resp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<Integer,String> questionIdMap = new HashMap<>();
		Map<String, Long> outputReportMap = new LinkedHashMap<>();
		List<TeacherModel> teacherModelList=new ArrayList<>();
		try {
			
			String teacherId = (String) req.getParameter("teacher");
			Connection con = DatabaseConnection.getInstance();
			PreparedStatement st = con.prepareStatement("select id,questionText  from question;");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String qText = rs.getString("questionText");
				
				questionIdMap.put(id, qText);
			}
			
			st = con.prepareStatement("select questionid,avg(mark) mark from feedback where teacherid=? group by questionid order by questionid;");
			st.setInt(1, Integer.parseInt(teacherId));
			rs = st.executeQuery();
			
			while(rs.next()) {
				int qid = rs.getInt("questionid");
				double mark = rs.getDouble("mark");
				
				outputReportMap.put(questionIdMap.get(qid), Math.round(mark));
			}
			teacherModelList=getTeacherModelList(con);
			
			req.setAttribute("selectedid", teacherId);
			req.setAttribute("teacherlist", teacherModelList);
			req.setAttribute("outputReportMap", outputReportMap);
			req.getRequestDispatcher("/Login/teacherselect.jsp").forward(req, resp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
