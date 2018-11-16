package com.feedback.changepassword;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.feedback.database.DatabaseConnection;

public class ChangePassword extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		String password = request.getParameter("currentpass");
		String newpass = request.getParameter("newpass");
		String confirm = request.getParameter("cnfrmpass");
		int id = 0;
		String pass="";
		
		try {

			Connection con = DatabaseConnection.getInstance();
			PreparedStatement st = con.prepareStatement("select * from teacher where password='"+password+"'");
			ResultSet rs=st.executeQuery();
			while(rs.next()){
				 id = rs.getInt(1);
				 pass = rs.getString(3);
			}
			if(password.equals(newpass)) {
				
				PreparedStatement st1 = con.prepareStatement("update teacher set password='"+newpass+"' where id='"+id+"'");
				request.getRequestDispatcher("/Login/coordinatorhome.jsp").forward(request, response);
				
				
				}
			else {
				System.out.println("Enter valid password");
			}
			
		
	}
		catch (Exception e) {
			System.out.println(e);
		}

}
}
