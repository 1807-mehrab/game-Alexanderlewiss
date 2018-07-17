package com.alex.gaamee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.alex.gaamee.ConnectionUtil;

public class AccountsDAO {
	
	// Method that creates an account on the AWS database using sql. 
	public boolean createAccount(int id, String userName, String passWord) {
		CallableStatement cs = null;
		boolean login = false;
		System.out.println("Connecting to database....");
		// Inserts the user account into the table 
	      try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = " INSERT INTO ACCOUNTS (id, userName, passWord,)(?, ?, ?)";
			cs = conn.prepareCall(sql);
			cs.setInt(1,id );
			cs.setString(2,userName);
			cs.setString(3,passWord);
			
			// If the query does not execute the program will say that the account failed
			//to be created
			
			Boolean result = cs.execute();
			if (!result) {
				System.out.println("Failed to create account");
				login = false; 
			} else {
				System.out.println("Account created!");
				login = true; 
			}
		
			cs.close();
			// Catches an exception
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	      // Returns if the user can log in true or false 
	      return login; 
	}
	// Verify's the user information to allow for login. 
	public boolean checkInformation(String u, String p)
	{
		boolean c = false; 
		System.out.println("Connecting to database....");
		// Connects to the database 
		try(Connection conn = ConnectionUtil.getConnection())
		{
			CallableStatement cs = null;
			 String sql = "SELECT * FROM ACCOUNT WHERE username=? AND passWord=?"; // Validation
			 cs = conn.prepareCall(sql);
			 ResultSet results = cs.executeQuery(sql);
		
			 if(!results.next())
			 {
				System.out.println("Invalid password or username "); 
				c = false; 
			 }
			 
			 else
			 {
			    c = true; 
			 }
			 
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		// Returns if the user account is valid. 
		return c;
	}
}





