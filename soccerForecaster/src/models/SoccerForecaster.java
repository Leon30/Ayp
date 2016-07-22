package models;

import views.IoManager;

public class SoccerForecaster {

    public static final int MAX_MATCHS = 20;
    public static final int MAX_TEAMS = 20;
    private Match[] matchList;
    private Team[] teamList;

    public SoccerForecaster() {
        matchList = new Match[MAX_MATCHS];
        teamList = new Team[MAX_TEAMS];
        initTeams();
    }
    
    public int getWinner(Match m){
        return m.calculateVictory();
    }

    public Team[] getTeamList() {
        return teamList;
    }
    
    public void initTeams(){
        for (int i = 0; i < Team.INIT_TEAMS_LIST.length; i++) {
            teamList[i] = Team.INIT_TEAMS_LIST[i];
        }
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
                return ;
            }
        }
    }
    
    public Match getMatch(int i){
        return matchList[i];
    }
}
