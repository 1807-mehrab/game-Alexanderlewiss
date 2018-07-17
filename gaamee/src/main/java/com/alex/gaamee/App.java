package com.alex.gaamee;
import java.util.Scanner;
import java.util.List;

import com.alex.gaamee.AccountsDAO;
import com.alex.gaamee.Account;
// App class that extends the sub class of threads which will allow the program to start. 
public class App extends Thread
{     
	private Parser p;
    private Worlds cWorld;
    // Main 
    public static void main( String[] args ) throws Exception
    {
    	App t1 = new App(); 
		AccountsDAO a = new AccountsDAO(); 
		Scanner input = new Scanner(System.in);
		Scanner inputs = new Scanner(System.in);
		boolean check = false; 
		String userName = null;
		String passWord = null;
		int id;
		Scanner inpu = new Scanner(System.in);
		String cu;
		String pu; 
		Scanner inp = new Scanner(System.in);
	
		System.out.println("Type C to create a account or S to login and start the game");
		
		String s = input.next();
		
		if(s.equals("C")) // Calls create account if player enters C 
		{
			System.out.println("Enter a id");
			id = inputs.nextInt();
			inputs.nextLine();
			System.out.println("Enter a User Name");
			userName = inputs.nextLine();
			System.out.println("Enter a Password");
			passWord = inputs.nextLine();
			a.createAccount(id, userName, passWord);
			t1.start(); 
		}
		
		if(s.equals("S")) // Validates the user input if they already have an account 
		{
			System.out.println("Enter your user name");
			cu = inpu.nextLine();
			System.out.println("Enter your password");
			pu = inp.nextLine(); 
			check = a.checkInformation(cu,pu); // Checks the information that the player enters. 
			
			if(check == true)
			{
				t1.start(); // Thread that starts the game. 
			} 
		}
    }
    
public void run() { // Runnable interface for the thread
		
		App game = new App();
		game.start();
		
	}

	public App() { // Creates the worlds and makes p a Parser object. 

		createWorlds();
		p = new Parser();
	}
// Method that creates the worlds for the game and also sets the exit worlds. 
	public void createWorlds() {

		Worlds enchantedDominion, castleCornelia, toyBox, alantica;
		enchantedDominion = new Worlds("Enchanted Dominion! Oh no! Maleficent has Stolen Aurora's heart! Please help save her! ");
		castleCornelia = new Worlds("7 warriors of light touch the crystals as they begin their journey ");
		toyBox = new Worlds("Andy is missing! Help Woody and Buz find their friend.  ");
		alantica = new Worlds("Ursula has stolen king Triton's triton. Help Arial get it back from Ursula. End of game Type quit. Or ED to play again.  ");

		enchantedDominion.exitWorld("Castle Cornelia ", castleCornelia);
		castleCornelia.exitWorld("ToyBox", toyBox);
		toyBox.exitWorld("Atlantica", alantica);
		alantica.exitWorld("Castle Cornelia", castleCornelia);

		cWorld = enchantedDominion;

	}
// Method that starts the game. 
	public void start()  {
		System.out.println();
		System.out.println("Myra: Hello pure hearted child welcome to this realm");
		System.out.println("Child: This place is beautiful I want to stay here forever. ");
		System.out.println("Myra: Yes it is! But dont be fooled darkness is every where...");
		System.out.println("Myra: Dont let it consume your heart ");
		System.out.println("Child: I wont give into the darkness. Never.. ");
		
		System.out.println(cWorld.getLWorldDesc());

		boolean done = false;
		while (!done) {
			Direct d = p.getCommand();
			done = commandProcessor(d);
		}
	}
// A method that processes the commands the user types in 
	private boolean commandProcessor(Direct direction)    {
		boolean quits = false;

		if (!direction.knowsFWord()) {
		
			System.out.println("Unknown command try again.");
			return false;
		}
		

		String fWord = direction.obtainFWord();
		
		try
		{
			 if(fWord.equals("die"))
			 {
			      throw new Exception(); 
			 }
		}
		catch(Exception e){
			System.out.println("You cannot die");
		}
		
		if (fWord.equals("move")) {
			travleWorlds(direction);
		}
		
		// else if(dWord.equals("Fight"))
		// {
                 
		// }
		else if (fWord.equals("help")) {
			System.out.println("Here are the Commands: go, move, fight, and quit");
			System.out.println("Type them in and make sure you are spelling them correctly");
		} else if (fWord.equals("quit")) {
			quits = quit(direction);
		}
		
	

		return quits;
	  }
	
// Function that allows the player to travel different worlds 
	private void travleWorlds(Direct direction) {
		if (direction.doesNotKnow()) {
			System.out.println("No location");

		}
		else {
			String d = direction.obtainDWord();
			Worlds nWorld = cWorld.leaveWorld(d);
	
			if (nWorld == null) {
				System.out.println("No world to go too");
			} else {
				cWorld = nWorld;
				System.out.println(cWorld.getLWorldDesc());
			}
		}
	}
// A Method that quits the program when quit is typed in 
	private boolean quit(Direct direction){

		if (!direction.knowsFWord()) {
			System.out.println("Invalid command");
			return false;
		} else {
			return true;
		}
		
	}
    
   
}
