package models;

import java.util.Scanner;

public class TextToolkit{

	private Scanner scanner;

	public TextToolkit(){
		scanner = new Scanner( System.in );
	}

	public int getSum(String string){
		int sum = 0;
		String number = "0";
		for ( int i = 0; i < string.length()+1 ; i++) {
			char iChar = ',';
			if (i != string.length()) {
				iChar = string.charAt(i);
			}
			if (iChar >= 48 && iChar <= 57) {
				number = number + iChar;
			}else if ((iChar == ',') || (i == string.length())) {
				int num = Integer.parseInt(number);
				sum += num;
				number = "0";
			}else {
				return -1;
			}
		}
		return sum;
	}

	public String getBestName(String string){
		String bestNameGrade = "";
		int higher = 0;
		String grade = "";
		String name = ""; 
		boolean isName = true;
		for ( int i = 0; i < string.length() ; i++) {
			char iChar = string.charAt(i);
			if (isName && iChar != 44) {
				name += iChar;
			}else if(iChar >= 48 && iChar <= 57){
				grade += iChar;
			}
			if(iChar == ','){
				isName = false;
			}else if(iChar == ';'){
				isName = true;
				int cast = Integer.parseInt(grade);
				if (cast > higher) {
					bestNameGrade = name;
					higher = cast;
				}
				grade = "";
				name = ""; 
			}
		}
		return bestNameGrade;
	}

	public String getMostDamagedSection(String string){
		int damagedNum = 0;
		int mostDamaged = 0;
		int mostDamagedStart = 0;
		int mostDamagedEnd = 0;
		int startDamage = 0;
		int endDamage = 0;
		for ( int i = 0; i < string.length() ; i++) { 
			char iChar = string.charAt(i);
			if (iChar == '_') {
				if (damagedNum > mostDamaged) {
					mostDamaged = damagedNum;
					mostDamagedStart = startDamage;
					mostDamagedEnd = endDamage;
				}
				damagedNum = 0;
			}else if(iChar == '.'){
				if ((i > 0) && string.charAt(i-1) != '.') {
					startDamage = i;
				}
				if (i < (string.length()-1) && string.charAt(i+1) != '.') {
					endDamage = i;
				}
				damagedNum++;
			}else{
				return "Error";
			}
		}
		return 	mostDamagedStart + "-" + mostDamagedEnd;
	}

	public static void main(String[] args) {
		TextToolkit t = new TextToolkit();
		System.out.println(t.getSum(t.scanner.nextLine()));
		System.out.println(t.getBestName(t.scanner.nextLine()));
		System.out.println(t.getMostDamagedSection(t.scanner.nextLine()));
	}
}