package models;

public class AnagramVerifier{

	private String invalidedChars = "";
	private String word1;
	private String word2;

	public AnagramVerifier(String word1, String word2){
		this.word1 = word1;
		this.word2 = word2;
	}

	public boolean isInvalided(int j){
		for (int i = 0; i < invalidedChars.length(); i++) {
			if (i == j) {
				return true;
			}
		}
		return false;
	}

	public boolean verify(){
		boolean hasFoundedChar;
		if (!(word1.length() == word2.length())) {
			return false;
		}
		for (int i = 0; i < word1.length(); i++) {
			hasFoundedChar = false;
			for (int j = 0; i < word2.length(); i++) {
				if ((word1.charAt(i) == word2.charAt(j)) && !isInvalided(j)) {
					invalidedChars += j;
					hasFoundedChar = true;
				}
			}
			if (hasFoundedChar == false) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		AnagramVerifier av = new AnagramVerifier("alas","sal");
		System.out.println(av.verify());
	}
}