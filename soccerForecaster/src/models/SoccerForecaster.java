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

    public Team calculateVictory(Match m){
    	if(m.getTeams[0].calculateTotalAverage() > m.getTeams[0].calculateTotalAverage()){
    	    return m.getTeams()[0];
    	}else if((m.getTeams[0].calculateTotalAverage() < m.getTeams[0].calculateTotalAverage()){
    	    return m.getTeams()[1];
    	}else{
    	    if(m.getTeams[0].getWiningMatches() > m.getTeams[0].getWiningMatches()){
    	        return m.getTeams()[0];
    	    }else{
    	        return m.getTeams()[1];
    	    }
    	}
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
