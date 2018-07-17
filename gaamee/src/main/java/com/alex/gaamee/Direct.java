package com.alex.gaamee;

public class Direct {

	private String dWord;
	private String fWord;
// Sets the first and second commands that the user enters. 
	public Direct(String fWord, String sWord) {
		dWord = sWord;
		this.fWord = fWord;

	}
// Returns the direction word 
	public String obtainDWord() {
		return dWord;
	}
//  Returns the first word 
	public String obtainFWord() {
		return fWord;

	}
// Checks to see if the first word is equal to null
	public boolean doesNotKnow() {
		return (fWord == null);
	}
// Checks to see if if the first word is not equal to null. 
	public boolean knowsFWord() {
		return (fWord != null);
	}

}
