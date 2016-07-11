package models;

public class Place{
	private int yPos;
	private int xPos;
	private Pokemon pokemon;
	private Player player;
	static public final int MAX_POKEMONS = 5;

	public Place(){
		xPos = (int) (Math.random()*PokemonGo.MAX_MAP_HEIGHT);
		yPos = (int) (Math.random()*PokemonGo.MAX_MAP_HEIGHT);
		if ((Math.random()*2) < 0.5) {
			player = new Player("Enemy");
			player.addRandomPokemon();
			player.addRandomPokemon();
			player.addRandomPokemon();
			player.addRandomPokemon();
		}
		int pokemonNumber = (int) ((Math.random()*Pokemon.POKEMON_LIST.length));
		this.pokemon = Pokemon.POKEMON_LIST[pokemonNumber];
	}

	public int[] getPos(){
		int[] pos = {xPos,yPos};
		return pos;
	}

	public Player getPlayer(){
		return player;
	}

	public Pokemon getPokemon(){
		return pokemon;
	}

	@Override
	public String toString(){
		if(player != null)player.printPokemons();
		return "Players: " + player + " poks: " + pokemon ;
	}
}