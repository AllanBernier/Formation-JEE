package com.jee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilConnexion {

	public static Connection seConnecter() throws Exception {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp", "root", "root");
		}
		catch (ClassNotFoundException e) {
			throw new Exception("ClassNotFoundException :" + e);
		} catch (SQLException e) {
			throw new Exception("SQLException :" + e);
		}
		
		
		
		
	}
}
