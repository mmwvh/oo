/**
 * 
 */
package opg02;

import java.util.ArrayList;

import opg01.Student;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class Main {

	private Board board;

	private final Pos[] knight = { new Pos(2, 1), new Pos(2, 1), new Pos(1, -2), new Pos(1, 2), new Pos(-2, -1),
			new Pos(-2, 1), new Pos(-1, -2), new Pos(-1, 2) };

	public Main() {
		
		board = new Board(6, 6);
		findTour(new Pos(0, 0), 1);
	}

	private boolean findTour(Pos p, int n) {
		if (!board.isClosed()) {
			for (Pos s : successors(p)) {
				board.set(s, n);
				boolean found = findTour(s, n + 1);
				if (found) {
					return true;
				} else {
					board.set(s, 0);	
				}
			}
			//System.out.println("No solution found for a " + board.getM() + " x " + board.getN() + " board.");
			return false;
		} else {
			System.out.println(board.toString());
			return true;
		}
	}

	private ArrayList<Pos> successors(Pos p) {
		ArrayList<Pos> s = new ArrayList<Pos>();

		for (Pos k : knight) {
			Pos x = new Pos(p.getX() + k.getX(), p.getY() + k.getY());
			if (board.isWinBounds(x) && board.get(x) == 0) {
				s.add(x);
			}
		}
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();

	}

}
