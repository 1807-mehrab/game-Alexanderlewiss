package Aexteam.Game;

public class Direct {

	private String dWord;
	private String fWord;

	public Direct(String fWord, String sWord) {
		dWord = sWord;
		this.fWord = fWord;

	}

	public String obtainDWord() {
		return dWord;
	}

	public String obtainFWord() {
		return fWord;

	}

	public boolean doesNotKnow() {
		return (fWord == null);
	}

	public boolean knowsFWord() {
		return (fWord != null);
	}

}
