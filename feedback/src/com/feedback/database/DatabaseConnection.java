package com.feedback.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection connectionObject;
	
	private DatabaseConnection(){
	     
    }
     
    public static Connection getInstance() throws SQLException, ClassNotFoundException{
    	if(connectionObject == null) {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		connectionObject = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback", "root", "root");
    	}
        return connectionObject;
    }
}
