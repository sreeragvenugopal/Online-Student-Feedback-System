package com.feedback.question;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.feedback.database.DatabaseConnection;
import com.feedback.model.ClassModel;
import com.feedback.model.QuestionModel;
import com.feedback.model.TeacherModel;

public class QuestionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<QuestionModel> questionModelList = new ArrayList<>();
		List<TeacherModel> teacherModelList = new ArrayList<>();
		try {
			Connection con = DatabaseConnection.getInstance();
			questionModelList = getQuestionModelList(con);
			teacherModelList = getTeacherModelList(con);

			req.setAttribute("questionlist", questionModelList);
			req.setAttribute("teacherlist", teacherModelList);

			req.getRequestDispatcher("/Login/studentfeedback.jsp").forward(req, resp);
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	private List<TeacherModel> getTeacherModelList(Connection con) throws SQLException {
		List<TeacherModel> teacherModelList = new ArrayList<>();
		PreparedStatement st = con.prepareStatement("select * from teacher");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			// fetching id, adminid, name to variables
			int id = rs.getInt("id");
			String name = rs.getString("name");

			// Creating QuestionModel Object
			TeacherModel teacherModel = new TeacherModel();
			teacherModel.setId(id);
			teacherModel.setName(name);

			// Adding QuestionModel Object to questionModelList
			teacherModelList.add(teacherModel);
		}

		return teacherModelList;
	}

	private List<QuestionModel> getQuestionModelList(Connection con) throws SQLException {
		List<QuestionModel> questionModelList = new ArrayList<>();
		PreparedStatement st = con.prepareStatement("select * from question");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			// fetching id, adminid, name to variables
			int id = rs.getInt("id");
			int adminid = rs.getInt("adminid");
			String questiontext = rs.getString("questionText");

			// Creating QuestionModel Object
			QuestionModel questionModel = new QuestionModel();
			questionModel.setId(id);
			questionModel.setAdminId(adminid);
			questionModel.setQuestionText(questiontext);

			// Adding QuestionModel Object to questionModelList
			questionModelList.add(questionModel);
		}

		return questionModelList;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// student id from session
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("id");
		// connection
		Connection con;
		try {
			con = DatabaseConnection.getInstance();
			PreparedStatement st = con
					.prepareStatement("insert into feedback (questionid,studentid,teacherid,mark) values(?,?,?,?)");
			String tname = req.getParameter("teacher");
			Enumeration<String> questionmap = req.getParameterNames();
			while (questionmap.hasMoreElements()) {
				String paramName = (String) questionmap.nextElement();

				if (paramName.equals("dept") || paramName.equals("teacher") || paramName.equals("year")
						|| paramName.equals("semester") || paramName.equals("subject")) {
					continue;
				}

				String feedback = req.getParameter(paramName);
				st.setInt(1, Integer.parseInt(paramName));
				st.setInt(2, id);
				st.setInt(3, Integer.parseInt(tname));
				st.setInt(4, Integer.parseInt(feedback));
				st.executeUpdate();
			}
			req.getRequestDispatcher("/Login/Studenthome.jsp").forward(req, resp);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
