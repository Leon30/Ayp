package models;

import java.util.Scanner;

public class RunGame{

	static public final char floorObstacle = '_';
	static public final char ceilingObstacle = '*';
	static public final char holeObstacle = ' ';
	static public final char forwardAction = 'w';
	static public final char bendAction = 's';
	static public final char jumpAction = 'd';
	private String level;
	private Scanner scanner;

	public RunGame(){
		scanner = new Scanner( System.in);
	}

	public void generateLevel(){
		int levelLength = (int) ((Math.random() * 5) + 5);
		level = "";
		for (int i = 0; i < levelLength; i++) {
			int chooseObstacle = (int) (Math.random()*3);
			switch (chooseObstacle) {
				case 0:
					level += floorObstacle;
				break;
				case 1:
					level += ceilingObstacle;
				break;
				case 2:
					level += holeObstacle;
			}
		}
	}

	public boolean checkWin(String userPlay){
		if (userPlay.length() == level.length()) {
			for (int i = 0; i < userPlay.length(); i++) {
				switch (level.charAt(i)) {
					case floorObstacle:
						return true;
					case ceilingObstacle:
						return userPlay.charAt(i) == bendAction;
					case holeObstacle:
						return userPlay.charAt(i) == jumpAction;
					default:
						return false;
				}
			}
		}else {
			return false;
		}
		return true;
	}

	public void play(){
		int lives = 3;
		while (lives > 0) {
			if (lives != 3) {
				System.out.println("Try again!");
			}
			generateLevel();
			System.out.println("Level: " + level + "|  Length: " + level.length());
			System.out.print("Enter commands:");
			String userPlay = scanner.nextLine();
			if(checkWin(userPlay)){
				System.out.println("You win");
				return ;
			}else {
				lives--;
				System.out.println("You lose");
			}
		}
		System.out.println("You lose!");
	}

	public static void main(String[] args) {
		RunGame g1 = new RunGame();
		g1.play();
	}
}