package com.gl.librarymanagement.dbconnection;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private final static String url ="jdbc:mysql://localhost:3306/library";
	private final static String user = "root";
	private final static String password = "Anju@112";
	
	private DBConnection() {
		
	}
	private static Connection con = null;
	@SuppressWarnings("unused")
	public static Connection getConnection() {
		if(con == null) {
	
		try {
			com.mysql.jdbc.Driver d = null;
			try{
				d = new com.mysql.jdbc.Driver();
			}
			catch(Exception e){
				System.out.println("ERROR BY NEW DRIVER" +e.toString()+"\n");
				e.printStackTrace();
			}
				
			{
			con = DriverManager.getConnection(url, user, password);
			
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		}
		return con;
}

}
