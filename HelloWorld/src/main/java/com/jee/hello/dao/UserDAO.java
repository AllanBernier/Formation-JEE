package com.jee.hello.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jee.hello.modele.User;


public class UserDAO extends DAOContext {

    public static User isValidLogin( String login, String password ) {
    	
    	System.out.println(dbURL + " - " + dbLogin + " - " + dbPassword);
    	
        try ( Connection connection = DriverManager.getConnection( dbURL, dbLogin, dbPassword ) ) {
            //String strSql = "SELECT * FROM T_Users WHERE login='" 
             //               + login + "' AND password='" + password + "'";
        	
            String strSql = "SELECT * FROM T_Users WHERE login=? AND password=?";
            try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
                statement.setString( 1, login );
                statement.setString( 2, password );
                try ( ResultSet resultSet = statement.executeQuery() ) {
                    if ( resultSet.next() ) {
                        return new User(
                                resultSet.getInt( "idUser" ),
                                resultSet.getString( "login" ),
                                resultSet.getString( "password" ),
                                resultSet.getString( "email" )
                        );
                    } else {
                        return null;
                    }
                }
            }
        } catch ( Exception exception ) {
            throw new RuntimeException( exception );
        }
    }
    
}
