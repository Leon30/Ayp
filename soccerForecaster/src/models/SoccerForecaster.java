package models;

import java.util.Scanner;

public class SoccerForecaster {

    public static final int MAX_TEAMS = 20;
    public static final int MAX_MATCHS = 20;
    private Match[] matchList;
    private Team[] teamList;

    public SoccerForecaster() {
        matchList = new Match[MAX_MATCHS];
        teamList = new Team[MAX_TEAMS];
        initTeams();
    }
    
    public void registerMatch(Match m){
        for (int i = 0; i < matchList.length; i++) {
            if (matchList[i] == null) {
                matchList[i]= m;
            }
        }
    }
    
    public void registerTeam(Team t){
        for (int i = 0; i < teamList.length; i++) {
            if (teamList[i] == null) {
                teamList[i]= t;
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
    
    public void getProbalility(){
        
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
