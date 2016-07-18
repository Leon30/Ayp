package models;

import java.util.Scanner;

public class SoccerForecaster {

    public static final int MAX_TEAMS = 20;
    private final Scanner scanner;
    private Match[] matchList;
    private Team[] teams;

    public SoccerForecaster() {
        scanner = new Scanner(System.in);
        teams = new Team[MAX_TEAMS];
        teams[0] = new Team("");
    }
    
    public void registerMatch(Match m){
        for (int i = 0; i < matchList.length; i++) {
            if (matchList[i] == null) {
                matchList[i]= m;
            }
        }
    }

    public double[] calculateVictory(Match m){
    	return new double[0];
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
