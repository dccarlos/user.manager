package com.itexico.user.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDriver {
	 public static void connect() {
	        Connection conn = null;
	        try {
	            String url = "jdbc:sqlite:/Users/developer/Downloads/springboot.db";
	            conn = DriverManager.getConnection(url);
	            System.out.println("You are connected.");
	            
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                System.out.println(ex.getMessage());
	            }
	        }
	    }
	 
}
