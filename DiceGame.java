package models;

import java.util.Scanner;

public class DiceGame{

	private String winWord = "GANADOR";
	private String userWinWord = "";
	private Scanner scanner;

	public DiceGame(){
		scanner = new Scanner( System.in );
	}

	public void addChar(){
		String tranWord = userWinWord;
		userWinWord = "";
		for (int i = 0; i < tranWord.length()+1; i++) {
			if (i == (userWinWord.length())) {
				userWinWord += winWord.charAt(i);
			}else {
				userWinWord += tranWord;
			}
		}
	}

	public void delChar(){
		String newWord = "";
		for (int i = 0; i < userWinWord.length(); i++) {
			if (!(i == (userWinWord.length()-1))) {
				newWord += userWinWord.charAt(i);
			}
		}
		userWinWord = newWord;
	} 

	public String playDices(){
		int userDice1 = (int) (Math.random() * 6);
		int userDice2 = (int) (Math.random() * 6);
		int pcDice1 = (int) (Math.random() * 6);
		int pcDice2 = (int) (Math.random() * 6);
		int userDices = userDice1 + userDice2;
		int pcDices = pcDice1 + pcDice2;
		if (userDices > pcDices) {
			addChar();
		}else if((userDices < pcDices) && !userWinWord.equals("")){
			delChar();
		}
		System.out.println(userWinWord.charAt(userWinWord.length()-1));
		return "Dados usuario: " + userDice1 + " - " + userDice2 + "\nDados pc: " + pcDice1 + " - " + pcDice2;
	}

	public void play(){
		while (!(userWinWord.equals(winWord))) {
			System.out.print("Presione enter para tirar los dados...");
			scanner.nextLine();
			System.out.println(playDices());
		}
		System.out.println("Has Ganado");
	}

	public static void main(String[] args) {
		DiceGame dg = new DiceGame();
		dg.play();
	}
}
