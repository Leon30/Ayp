package models;

public class Pokemon{

	private int attack;
	private double health;
	private String name;
	private int yPos;
	private int xPos;
	private String type;
	static public final int START_HEALTH = 100;
	static public final int MAX_ATTACK = 20;
	static public final Pokemon[] POKEMON_LIST = {new Pokemon("squirtle","agua"), new Pokemon("pikachu","electrico"), new Pokemon("charmander","fuego"), new Pokemon("Bayleef", "Planta")};

	public Pokemon(String name, String type){
		this.attack = (int) (Math.random() * MAX_ATTACK);
		this.health = START_HEALTH;
		this.name = name;
		this.type = type;
	}

	public boolean fight(Pokemon enemyPokemon){
		if (enemyPokemon.getForce() == attack) {
			if (Math.random() > 0.5) {
				return true;
			}else {
				return false;
			}
		}else if(enemyPokemon.getForce() > attack){
			return true;
		}else {
			return false;
		}
	}

	public int getForce(){
		return attack;
	}

	public String getName(){
		return name;
	}

	@Override
	public String toString(){
		return name + " Attack: " + attack + " Health: " + health + " Type: " + type;
	}
}