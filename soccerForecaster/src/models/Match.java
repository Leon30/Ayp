package models;

public class Match {
    private Team[] teams;
    private Tournament tournament;
    private Round round;

    public Match(Team[] teams, Tournament tournament, Round round) { 
        this.teams = new Team[2];
        for (int i = 0; i < teams.length; i++) {
            this.teams[i] = teams[i];
        }
        this.tournament = tournament;
        this.round = round;
    }
    
    public Team[] getTeams(){
    	return teams;
    }
    
    public int calculateVictory(){
        System.out.println(teams[1]);
    	if (teams[0].getTotalRating() > teams[1].getTotalRating() || teams[0].getWiningMatches() > teams[1].getWiningMatches()) {
            return 0;
        }else if (teams[0].getTotalRating() > teams[1].getTotalRating()) {
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "{" + "teams: " + teams + ", tournament: " + tournament + ", round: " + round + '}';
    }
}
