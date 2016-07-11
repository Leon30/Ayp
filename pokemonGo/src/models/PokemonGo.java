package models;

import java.util.Scanner;

public class PokemonGo{

	static public final int MAX_PLAYERS = 10;
	static public final int MAX_PLACES = 5;
	static public final int MAX_MAP_HEIGHT = 100;
	static public final int MAX_CAPTURE_DIST = 5;
	private Scanner scanner;
	private Player[] players;
	private Place[] places;

	public PokemonGo(){
		players = new Player[MAX_PLAYERS];
		places = new Place[MAX_PLACES];
		places[0] = new Place();
		places[1] = new Place();
		places[2] = new Place();
		places[3] = new Place();
		places[4] = new Place();
		scanner = new Scanner(System.in);
	}

	public void addPlayer(Player player){
		for (Player p: players) {
			if (p != null && p.getName() == player.getName()) {
				System.out.println("El jugador ya existe.");
				return ;
			}
		}
		for (Player p: players) {
			if (p == null) {
				p = player;
				System.out.println("Jugador anadido.");
				return ;
			}
		}
		System.out.println("No se pueden agregar mas jugadores.");
	}

	public Player searchPlayer(){
		printPlayers();
		System.out.println("Escriba el nombre del jugador:");
		scanner.nextLine();
		String name = scanner.nextLine();
		for (Player p: players) {
			if (p != null && p.getName() == name) {
				return p;
			}
		}
		System.out.println("Jugador no encontrado");
		return null;
	}

	public void deletePlayer(Player p){
		p = null;
	}

	public void printPlayers(){
		for (Player p: players) {
			//if (p != null) {
				System.out.println(p);
			//}
		}
	}

	public void showPlayerMenu(){
		System.out.println("");
	}

	public void showStartMenu(){
		printPlayers();
		System.out.println("1: agregar jugador | 2: borrar jugador | 3: jugar");
		int opt = scanner.nextInt();
		switch(opt){
			case 1:
				System.out.println("Ingrese el nombre:");
				String name = scanner.next();
				Player player = new Player(name);
				addPlayer(player);
				showStartMenu();
			break;
			case 2:
				deletePlayer(searchPlayer());
				showStartMenu();
			break;
			case 3:
				play(searchPlayer());
			default:
				System.out.println("Opcion incorrecta");
				showStartMenu();
		}
	}

	public Place checkPlace(Player p){
		int xP = p.getPos()[0];
		int yP = p.getPos()[1];
		for (int i = 0; i < places.length; i++) {
			int x = places[i].getPos()[0];
			int y = places[i].getPos()[1];
			int dist = (int) (Math.sqrt(Math.pow(x - xP, 2) + Math.pow(y - y, 2)));
			if (dist <= MAX_CAPTURE_DIST) {
				return places[i];
			}
		}
		return null;
	}

	public void capturePokemon(Place place, Player player){
		System.out.println("Has capturado a:" + place.getPokemon());
		player.addPokemon(place.getPokemon(), true);
	}

	public void fight(Place place, Player player){
		System.out.println("Vas a pelear contra: " + place.getPlayer());
		boolean hasChoosen = false;
		while (!hasChoosen) {
			System.out.println("Escriba el nombre del pokemon que quiere usar:");
			Pokemon userPok = player.choosePokemon(scanner.nextLine());
			if (userPok != null) {
				hasChoosen = true;
				userPok.fight(place.getPokemon());
			}
		}
	}

	public void interactWithPlace(Player player, Place place){
		if (place.getPlayer() != null) {
			if (place.getPokemon() != null) {
				System.out.println("Hay un pokemon y otro jugador!");
				System.out.println("Que queres hacer:\t1: capturar pokemon 2: pelear 0: Nada");
				int op = scanner.nextInt();
				switch (op) {
					case 1:
						capturePokemon(place,player);
					break;
					case 2:
						fight(place,player);
					default:
						play(player);
				}
			}else {
				System.out.println("Desea luchar?(Y)");
				if (scanner.nextLine().charAt(0) == 'Y') {
					fight(place,player);
				}else {
					play(player);
				}
			}
		}else if (place.getPokemon() == null) {
			System.out.println("No hay nada...");
			play(player);
		}else {
			System.out.println("Hay un pokemon. Capturarlo(Y)");
			if (scanner.nextLine().charAt(0) == 'Y') {
				capturePokemon(place,player);
			}else {
				play(player);
			}
		}
	}

	public void play(Player player){
		if (player != null) {
			System.out.println("Se encuentra en " + player.getPos()[0] + ", " + player.getPos()[1]);
			System.out.println("Escriba las condenadas a las que quiere ir:");
			if (player.setPos(scanner.nextInt(), scanner.nextInt())) {
				interactWithPlace(player, checkPlace(player));
			}
		}
	}

	public static void main(String[] args) {
		PokemonGo pg = new PokemonGo();
		pg.showStartMenu();
	}
}