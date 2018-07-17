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
	public boolean createAccount(int ID, String USERNAME, String PASSWORD) {
		CallableStatement cs = null;
		boolean login = false;
		Account a = null;
		System.out.println("Connecting to database....");
		// Inserts the user account into the table 
	      try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL SP_Create_Account(?, ?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1,ID );
			cs.setString(2,USERNAME);
			cs.setString(3,PASSWORD);
			
			a = new Account(ID,USERNAME,PASSWORD);
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
			//conn.close();
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
			 String sql = "{CALL SP_CHECK_INFO(?, ?, ?)}"; // Stored procedure validation
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
			 //conn.close();
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		// Returns if the user account is valid. 
		return c;
	}
}





