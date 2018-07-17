package com.alex.gaamee;
// A class for accounts 
public class Account {
	private int id;
	private String userName;
	private String passWord;
// Returns the ID
	public int getId() {
		return id;
	}
// Sets the id variable to the id passed in
	public void setId(int id) {
		this.id = id;
	}
// returns the username 
	public String getUserName() {
		return userName;
	}
// Sets the username to the username passed in 
	public void setName(String userName) {
		this.userName = userName;
	}
// Retuns the passwrod 
	public String getPassWord() {
		return passWord;
	}
// Sets the password to the passwrod passed in 
	public void setAge(String passWord) {
		this.passWord = passWord;
	}

// Overridded method that returns the users information. 
	@Override
	public String toString() {
		return "Account [id=\" + id + \", userName=\" + userName + \"passWord=\" + passWord \"]";
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int id, String userName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		
	}
	
	

}

