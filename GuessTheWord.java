package models;

import java.util.Scanner;

public class GuessTheWord{

	private String word;
	private String userWord;
	private Scanner scanner;
	static public final double occultPercent = 0.75;
	static public final char occultSymbol = '_';

	public GuessTheWord(String word){
		this.word = word;
		userWord = "";
		scanner = new Scanner( System.in );
	}

	public boolean hasOcculted(int charsToOccult){
		int occultedWords = 0;
		for (int i = 0 ; i < userWord.length(); i++) {
			if (userWord.charAt(i) == occultSymbol) {
				occultedWords++;
			}
			if (occultedWords == charsToOccult) {
				return true;
			}
		}
		return false;
	}

	public void occultChars(){
		int charsToOccult = (int) (word.length() * occultPercent);
		while (!hasOcculted(charsToOccult)) {
			userWord = "";
			for (int i = 0 ; i < word.length(); i++) {
				int randomPos = (int) (Math.random() * word.length());
				if (randomPos == i) {
					userWord = userWord + occultSymbol;
				}else {
					userWord = userWord + word.charAt(i);
				}
			}
		}
		System.out.println(userWord);
	}

	public void showWin(){
		System.out.println("Correcto!\nNueva Palabra: " + userWord);
	}

	public void tryWord(int pos, char charToTry){
		if (word.charAt(pos - 1) == charToTry) {
			if (userWord.charAt(pos - 1) == occultSymbol) {
				String tranUserWord = userWord;
				userWord = "";
				for (int i = 0 ; i < tranUserWord.length(); i++) {
					if ( (pos - 1) == i) {
						userWord = userWord + word.charAt(pos - 1);
					}else {
						userWord = userWord + tranUserWord.charAt(i);
					}
				}
				showWin();
			}
		}else {
			System.out.println("Incorrecto");
		}
	}

	public void play(){
		occultChars();
		while (!(userWord.equals(word))) {
			System.out.println("Ingrese la posiscion a cambiar.");
			int posIn = scanner.nextInt();
			System.out.println("Ingrese la letra.");
			tryWord(posIn, scanner.next().charAt(0));
		}
		System.out.println("Has ganado!");
	}

	public static void main(String[] args) {
		GuessTheWord gw = new GuessTheWord("aeropuerto");
		gw.play();
	}
}