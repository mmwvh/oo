import java.util.ArrayList;

/**
 * 
 * @author Franka Buytenhuijs s4356845
 * @author Wesley van Hoorn s4018044
 *
 */
public class Bord {
	private boolean gesloten = true; // of er een gesloten of open pad gevonden
										// moet worden

	private int schaakbord[][] = null;

	private boolean solutionfound = false;

	public Bord() {
		this.schaakbord = new int[OO3_2.size][OO3_2.size];
	}

	public void start(Positie pos, int diepte) {
		/**
		 * start het spel en initialiseerd de startplek met 1
		 */
		schaakbord[pos.getX()][pos.getY()] = diepte;
		MoveKnight(pos, diepte + 1);

	}
	
	private boolean closed(Positie pos){
		/**
		 * Kijkt of de route geloten is. TRUE if gesloten, FALSE als niet gesloten
		 */
		ArrayList<Positie> opvolgers = pos.opvolgers();
		for(Positie positie: opvolgers){
			int x = positie.getX();
			int y = positie.getY();
			if(schaakbord[x][y] == 1){
				return true;
			}
		}
		return false;
	}

	public void MoveKnight(Positie pos, int diepte) {
		/**
		 * recursieve functie. basecase: bekijken of de jusiste diepte bereikt
		 * is anders functie opnieuw aanroepen met de opvolgers van de huidige
		 * positie
		 */
		int x = pos.getX();
		int y = pos.getY();
		if (solutionfound) {
			return;
		}
		if (diepte == ((OO3_2.size * OO3_2.size)+1)) {
			if ((closed(pos)) && gesloten) {
				System.out.println("klaar");
				printBord();
				solutionfound = true;
			} else if (!gesloten) {
				System.out.println("klaar");
				printBord();
				solutionfound = true;
			}

		}

		ArrayList<Positie> sorted = heuristic(pos);

		for (int i = 0; i < sorted.size(); i++) {
			Positie pos2 = new Positie(sorted.get(i).getX(), sorted.get(i)
					.getY());
			int x2 = pos2.getX();
			int y2 = pos2.getY();
			if (!isVisited(x2, y2)) {
				schaakbord[x2][y2] = diepte;
				MoveKnight(pos2, diepte + 1);
				schaakbord[x2][y2] = 0;
			}
		}
	}

	public ArrayList<Positie> heuristic(Positie pos) {
		/**
		 * sorteert de opvolgers van Positie pos naar aantal opvolgers van klein
		 * naar groot
		 */
		ArrayList<Positie> successors = pos.opvolgers();
		ArrayList<Positie> sorted = new ArrayList<Positie>();
		int size = successors.size();
		while (size != sorted.size()) {
			Positie choosen = null;
			int minWeight = Integer.MAX_VALUE;

			for (Positie positie : successors) {
				int curWeight = positie.weight();
				if (curWeight < minWeight) {
					choosen = positie;
					minWeight = curWeight;
				}
			}
			if (choosen == null) {
				return null;
			} else {

				sorted.add(choosen);
				successors.remove(choosen);
			}
		}
		return sorted;

	}

	public boolean isVisited(int x, int y) {
		/**
		 * checks if the place has already been visited. TRUE if visited. FALSE if not visited
		 */

		return schaakbord[x][y] != 0;
	}

	public void printBord() {
		/**
		 * prints the chessboard
		 */
		for (int i = 0; i < OO3_2.size; i++) {
			for (int j = 0; j < OO3_2.size; j++) {
				System.out.print(schaakbord[i][j] + " ");
			}
			System.out.println("");
		}
	}

}