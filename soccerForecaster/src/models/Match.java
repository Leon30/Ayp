package models;

public class Match {
    private Team[] teams;
    private Tournament tournament;
    private Round round;

    public Match(Team[] teams, Tournament tournament, Round round) { 
        if (teams.length == 2)this.teams = teams;
        this.tournament = tournament;
        this.round = round;
    }
    
    public Team[] getTeams(){
    	return teams;
    }
    
    public Tournament getTournament(){
        
    }
    
    public Round getRound(){
        
    }
}
