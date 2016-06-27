package models;

import java.util.Scanner;

public class PowerStation{

	public static final char highVoltageSym = '*';
	public static final char normalVoltageSym = '_';
	private String power;
	private int alerts;
	private int blackouts;

	public void enterPower(String power){
		this.power = power;
	}

	public void verifyAlert(){
		char actualChar = ' ';
		char preChar = ' ';
		for (int i = 0; i < power.length(); i++) {
			if (i > 1) {
				actualChar = power.charAt(i);
				preChar = power.charAt(i-1);
				if ((actualChar == preChar) && (power.charAt(i) == highVoltageSym)) {
					alerts++;
				}
			}
		}
	}

	public void verifyBlackout(){
		char actualChar;
		char preChar;
		char pre2Char;
		for (int i = 0; i < power.length(); i++) {
			if (i > 2) {
				actualChar = power.charAt(i);
				preChar = power.charAt(i-1);
				pre2Char = power.charAt(i-2);
				if ((actualChar == preChar && actualChar == pre2Char) && (power.charAt(i) == highVoltageSym)) {
					blackouts++;
					alerts--;
				}
			}
		}
	}

	public void getReport(){
		verifyAlert();
		verifyBlackout();
		System.out.println("Alertas: " + alerts + "\nApagones: " + blackouts);
	}

	public void start(){
		boolean report;
		while (report) {
			report = scanner.nextInt() ? 0 : 1;
		}
	}

	public static void main(String[] args) {
		PowerStation pw = new PowerStation();
		pw.enterPower("__**____**____");
		pw.getReport();
		pw.start();
	}
}