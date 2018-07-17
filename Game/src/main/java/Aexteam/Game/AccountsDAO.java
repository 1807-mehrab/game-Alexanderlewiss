package Aexteam.Game;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import Aexteam.Game.Account;
import Aexteam.Game.ConnectionUtil;

public class AccountsDAO {
	
	
	public boolean createAccount(int id, String userName, String passWord) {
		CallableStatement cs = null;
		boolean login = false;
		System.out.println("Connecting to database....");
		
	      try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = " INSERT INTO ACCOUNTS (id, userName, passWord,)(?, ?, ?)";
			cs = conn.prepareCall(sql);
			cs.setInt(1,id );
			cs.setString(2,userName);
			cs.setString(3,passWord);
			
			
			Boolean result = cs.execute();
			if (!result) {
				System.out.println("Failed to create account");
				login = false; 
			} else {
				System.out.println("Account created!");
				login = true; 
			}
			
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	      
	      return login; 
	}
	
	public boolean checkInformation(String u, String p)
	{
		boolean c = false; 
		System.out.println("Connecting to database....");
		try(Connection conn = ConnectionUtil.getConnection())
		{
			CallableStatement cs = null;
			 String sql = "SELECT * FROM ACCOUNT WHERE username=? AND passWord=?"; 
			 cs = conn.prepareCall(sql);
			 ResultSet results = cs.executeQuery(sql);
			 
			 if(!results.next())
			 {
				System.out.println("Invalid password"); 
				c = false; 
			 }
			 
			 else
			 {
			    c = true; 
			 }
			 
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return c;
	}
}





