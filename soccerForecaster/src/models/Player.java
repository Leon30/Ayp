package models;

public class Player {

    private String name;
    private double average;
    private double shape;
    public static final int MAX_PLAYERS  = 30;
    public static final Player[] INIT_PLAYER_LIST = {new Player("Messi",90,80),new Player("Crsitiano",91,70),new Player("Griezman",85,80),new Player("",0,0)};

    public Player(String name, double average, double shape) {
        this.name = name;
        this.average = average;
        this.shape = shape;
    }
    
    public double getAverage(){
    	return average;
    }

    public double getShape(){
    	return shape;
    }
}
