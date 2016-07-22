package models;

public class Player {

    private String name;
    private double average;
    private double shape;
    private Nacionality nacionality;
    public static final int MAX_PLAYERS  = 30;
    public static final Player[] INIT_PLAYER_LIST = {new Player("Messi",90,80, Nacionality.ARGENTINE),new Player("Neymar",91,70,Nacionality.BRAZILIAN),new Player("Griezman",85,80,Nacionality.FRENCH),new Player("James",50,50,Nacionality.COLOMBIAN)};

    public Player(String name, double average, double shape, Nacionality nacionality) {
        this.name = name;
        this.average = average;
        this.shape = shape;
        this.nacionality = nacionality;
    }
    
    public double getAverage(){
    	return average;
    }

    public double getShape(){
    	return shape;
    }

    @Override
    public String toString() {
        return "{" + "name: " + name + ", average: " + average + ", shape: " + shape + ", nacionality: " + nacionality + '}';
    }
    
    
}
