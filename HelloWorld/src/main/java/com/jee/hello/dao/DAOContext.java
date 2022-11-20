package com.jee.hello.dao;


import javax.servlet.ServletContext;


public class DAOContext {


    protected static String dbURL;
    protected static String dbLogin;
    protected static String dbPassword;

    
    public static void init( ServletContext context ) {
    	    	
        try {
			Class.forName("com.mysql.jdbc.Driver");
			dbURL = "jdbc:mysql://localhost:3306/MyApp";
	    	dbLogin = "root";
	    	dbPassword = "root";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

    	
    }
}
