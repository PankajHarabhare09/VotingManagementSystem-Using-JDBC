package com.election.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection 
{
	private static final String url = "jdbc:mysql://localhost:3306/Election";
	private static final String user = "root";
	private static final String pass = "system";
	
	public static Connection dbms() throws SQLException
	{
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}
}
