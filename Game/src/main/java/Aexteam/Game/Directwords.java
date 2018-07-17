package Aexteam.Game;

public class Directwords {
	private static final String[] validDirectWords = { "move", "fight", "quit", "help", "CC", "ToyBox", "AL", "TB", "ED", "die" };

	// public Directwords() {};

	public boolean validWord(String in) {
		for (int i = 0; i < validDirectWords.length; i++) {
			if (validDirectWords[i].equals(in)) {
				return true;
			}
		}
		return false;
	}

	public void printData() {
		for (String c : validDirectWords) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

}
