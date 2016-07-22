package models;

public class Team {
    
    public static final int MAX_PLAYERS  = 20;
    private String name;
    private Tournament tournament;
    private Player [] playerList;
    private int winingMatches;
    public static final Team[] INIT_TEAMS_LIST = {new Team("Barcelona", Tournament.LIGA_BBVA, 2).addPlayer(Player.INIT_PLAYER_LIST[0]).addPlayer(Player.INIT_PLAYER_LIST[1]),
        new Team("Atletico Madrid", Tournament.LIGA_BBVA, 2).addPlayer(Player.INIT_PLAYER_LIST[2]),
        new Team("Real Madrid", Tournament.LIGA_BBVA,10).addPlayer(Player.INIT_PLAYER_LIST[3])};

    public Team(String name, Tournament tournament, int winingMatches) {
        this.name = name;
        this.tournament = tournament;
        this.winingMatches = winingMatches;
        playerList = new Player[MAX_PLAYERS];
    }

    public String getName() {
        return name;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public Team addPlayer(Player p){
    	for (int i = 0; i < playerList.length; i++) {
    		if (playerList[i] == null) {
    			playerList[i] = p;
    		}
    	}
        return this;
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
    
    public double calculateTotalShape(){
    	int noNullPlayers = 0;
    	double adder = 0;
    	for (Player p : playerList) {
    		adder += p.getShape();
    		if (p != null) {
    			noNullPlayers++;
    		}
    	}
    	return adder / noNullPlayers;
    }
    
    public double getTotalRating(){
        return calculateTotalAverage() + calculateTotalShape();
    }
    
    public Player getBestPlayer(){
        double pastAverage = 0;
        Player pastP = null;
        for (Player player : playerList) {
            if (player.getAverage() > pastAverage) {
                pastAverage = player.getAverage();
                pastP = player;
            }
        }
        return pastP;
    }

    public int getWiningMatches() {
        return winingMatches;
    }
    
    @Override
    public String toString(){
        if (getBestPlayer() == null) {
            return name + ", " + tournament;
        }
        return name + ", " + tournament + ", Best: " + getBestPlayer();
    }
}
