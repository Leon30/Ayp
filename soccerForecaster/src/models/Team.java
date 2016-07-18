package models;

public class Team {
    private String name;
    private Player [] playerList;
    private Tournament[] winingTournaments;
    private int winingMatches;

    public Team(String name) {
        this.name = name;
        this.winingTournaments = winingTournaments;
    }

    public void addPlayer(Player p){
    	for (int i = 0; i < playerList.length; i++) {
    		if (playerList[i] == null) {
    			playerList[i] = p;
    		}
    	}
    }

    public void addTournament(Tournament t){
    	for (int i = 0; i < winingTournaments.length; i++) {
    		if (winingTournaments[i] == null) {
    			winingTournaments[i] = t;
    		}
    	}
    }

    public double calculateTotalAverage(){
    	int noNullPlayers = 0;
    	double adder = 0;
    	for (Player p : playerList) {
    		adder += p.getAverage();
    		if (p != null) {
    			noNullPlayers++;
    		}
    	}
    	return adder / noNullPlayers;
    }
}
