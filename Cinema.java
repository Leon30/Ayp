package models;

public class Cinema{

	private String chairs = "";
	private int numberOfChairs;

	public Cinema(int numberOfChairs){
		this.numberOfChairs = numberOfChairs;
		for (int i = 0; i < numberOfChairs; i++) {
			chairs = chairs + ".";
		}
	}

	public boolean isFull(){
		for (int i = 0; i < chairs.length(); i++) {
			if (chairs.charAt(i) == '.') {
				return false;
			}
		}
		return true;
	}

	public int calculateOccupedChairs(){
		int chairsOcc = 0;
		for (int i = 0; i < chairs.length(); i++) {
			if (chairs.length() == '-') {
				chairsOcc++;
			}
		}
		return chairsOcc;
	}

	public boolean isShowStarted(){
		return numberOfChairs/2 == calculateOccupedChairs();
	}

	public void occupyChair(int chair){
		if (chairs.charAt(chair) == '.') {
			char[] chairsArray = chairs.toCharArray();
			chairsArray[chair]='-';
			chairs = chairsArray.toString();
		}else {
			System.out.println("Puesto ocupado.");
		}
	}

	public void printState(){
		if (isFull()) {
			System.out.println("La sala esta llena y el show ha empezado.");
		}else if (isShowStarted()) {
			System.out.print("El show ha empezado.");
		}else {
			System.out.println("La funcion esta a la espera");
		}
	}

	public static void main(String[] args) {
		Cinema cc = new Cinema(10);
		cc.occupyChair(4);
		cc.occupyChair(9);
		cc.occupyChair(7);
		cc.occupyChair(1);
		cc.occupyChair(2);
		cc.occupyChair(3);
		cc.printState();
	}
}