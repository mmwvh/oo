import java.util.ArrayList;

/**
 * 
 * @author Franka Buytenhuijs s4356845
 * @author Wesley van Hoorn s4018044
 *
 */

public class Positie {
	private int x;
	private int y;

	public Positie(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public ArrayList<Positie> opvolgers() {
		/**
		 * berekent alle opvolgers voor de huidige positie
		 */

		ArrayList<Positie> successors = new ArrayList<>();
		successors.add(new Positie(x + 2, y + 1));
		successors.add(new Positie(x + 2, y - 1));
		successors.add(new Positie(x - 2, y + 1));
		successors.add(new Positie(x - 2, y - 1));
		successors.add(new Positie(x + 1, y + 2));
		successors.add(new Positie(x + 1, y - 2));
		successors.add(new Positie(x - 1, y + 2));
		successors.add(new Positie(x - 1, y - 2));
		return validMove(successors);

	}

	public ArrayList<Positie> validMove(ArrayList<Positie> successors) {
		/**
		 * kijkt of de move een valid move is in de zin dat de move niet buit
		 * het bord valt
		 */
		ArrayList<Positie> returnValue = new ArrayList<>();
		for (Positie pos : successors) {
			if ((pos.x >= 0) && (pos.x < OO3_2.size) && (pos.y >= 0)
					&& (pos.y < OO3_2.size)) {
				returnValue.add(pos);
			}
		}
		return returnValue;
	}

	public int weight() {
		/**
		 * berekent het aantal opvolgers van een positie
		 */
		return opvolgers().size();
	}
}