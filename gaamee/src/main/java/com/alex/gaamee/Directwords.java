package com.alex.gaamee;
// Declares and initializes a string array of valid words
//the player can input. 
public class Directwords {
	private static final String[] validDirectWords = { "move", "fight", "quit", "help", "CC", "ToyBox", "AL", "TB", "ED", "die" };

	
// A method that determines if a word is valid. 
	public boolean validWord(String in) {
		for (int i = 0; i < validDirectWords.length; i++) {
			if (validDirectWords[i].equals(in)) {
				return true;
			}
		}
		return false;
	}
// A method that prints the array of valid words. 
	public void printData() {
		for (String c : validDirectWords) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	
}
