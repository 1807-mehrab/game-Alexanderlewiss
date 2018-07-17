package Aexteam.Game;

public class Account {
	private int id;
	private String userName;
	private String passWord;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setAge(String passWord) {
		this.passWord = passWord;
	}


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
