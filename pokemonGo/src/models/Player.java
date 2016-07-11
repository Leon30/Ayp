package models;

public class Player{

	static public final int MAX_INVENTORY_CAPACITY = 10;
	static public final int MAX_MOVE_DIST = 5;
	private String name;
	private Pokemon[] pokemons;
	private int yPos;
	private int xPos;


	public Player(String name){
		this.name = name;
		pokemons = new Pokemon[MAX_INVENTORY_CAPACITY];
		xPos = (int) (Math.random()*PokemonGo.MAX_MAP_HEIGHT);
		yPos = (int) (Math.random()*PokemonGo.MAX_MAP_HEIGHT);
	}

	@Override
	public String toString(){
		return name;
	}

	public void printPokemons(){
		for (Pokemon p: pokemons) {
			if(p != null)System.out.println(p);
		}
	}

	public boolean setPos(int x, int y){
		int dist = (int) (Math.sqrt(Math.pow(x - xPos, 2) + Math.pow(y - yPos, 2)));
		if (dist <= MAX_MOVE_DIST) {
			xPos = x;
			yPos = y;
			return true;
		}else {
			System.out.println("Estas muy lejos para llegar a ese punto.");
			return false;
		}
	}

	public int[] getPos(){
		int[] pos = {xPos,yPos};
		return pos;
	}

	public String getName(){
		return name;
	}

	public void addRandomPokemon(){
		if ((Math.random()*2) < 1) {
			int pokemonNumber = (int) ((Math.random()*Pokemon.POKEMON_LIST.length));
			addPokemon(Pokemon.POKEMON_LIST[pokemonNumber], false);
		}
	}

	public Pokemon choosePokemon(String name){
		printPokemons();
		for (Pokemon p: pokemons) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		System.out.println("No existe ese pokemon.");
		return null;
	}

	public Pokemon chooseRandomPokemon(){
		boolean hasChoosen = false;
		while (!hasChoosen) {
			int chooseNum = (int) (Math.random() * pokemons.length);
			if (pokemons[chooseNum] != null) {
				hasChoosen = true;
				return pokemons[chooseNum];
			}
		}
		return null;
	}

	public void addPokemon(Pokemon pokemon, boolean showMess){
		for (Pokemon p: pokemons) {
			if (p != null && p.getName() == pokemon.getName()) {
				if(showMess)System.out.println("El pokemon ya existe.");
				return ;
			}
		}
		for (Pokemon p: pokemons) {
			if (p == null) {
				p = pokemon;
				if(showMess)System.out.println("Pokemon anadido.");
				return ;
			}
		}
		if(showMess)System.out.println("No se pueden agregar mas pokemons.");
	}
}