package Aexteam.Game;

import java.util.Scanner;

public class Parser {
	private Directwords direction;
	private Scanner read;

	public Parser() {
		direction = new Directwords();
		Scanner s = new Scanner(System.in);
		read = new Scanner(System.in);
	}

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

	public void displayDirections() {
		direction.printData();
		
	}
}
