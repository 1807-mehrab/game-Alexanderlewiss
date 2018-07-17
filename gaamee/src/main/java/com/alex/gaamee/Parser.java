package com.alex.gaamee;

import java.util.Scanner;
// Parser class declares two object variables 
public class Parser {
	private Directwords direction;
	private Scanner read;
// Constructor for Parser which initializes direction, scanner, and read objects. 
	public Parser() {
		direction = new Directwords();
		Scanner s = new Scanner(System.in);
		read = new Scanner(System.in);
	}
// Get the commands that the user passes in 
	public Direct getCommand() {
		
		String input;
		String wOne = null; 
		String Wtwo = null; 

		System.out.println(" > ");
		input = read.nextLine();

		Scanner t = new Scanner(input);
		if (t.hasNext()) {
			wOne = t.next();
			if (t.hasNext()) {
				Wtwo = t.next();
			}

		}

		if (direction.validWord(wOne)) {
			return new Direct(wOne, Wtwo);

		} else {
			return new Direct(null, Wtwo);
		}

	}
// Displays the game directions for the player.
	public void displayDirections() {
		direction.printData();
		
	}
}
