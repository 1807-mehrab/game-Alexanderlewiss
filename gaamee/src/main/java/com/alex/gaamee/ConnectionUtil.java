package com.alex.gaamee;
import java.io.File;


import java.io.*;
import java.sql.*;
import java.util.Properties;
// Reads from the file connection.Properties and attempts to connect to the AWS database. 
public class ConnectionUtil {
	public static Connection getConnection() throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream("connection.properties");
		
		prop.load(in);
		
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		return DriverManager.getConnection(url, user, password);
	}
}