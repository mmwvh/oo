/**
 * Een Punt in 2D
 * 
 * @author pieter koopman
 */

public class Punt {
	private int x, y;

	/**
	 * de gewone constructor
	 * 
	 * @param i
	 *            : x
	 * @param j
	 *            ; y
	 */
	public Punt(int i, int j) {
		x = i;
		y = j;
	}

	/**
	 * copy constructor
	 * 
	 * @param p
	 */
	public Punt(Punt p) {
		if (p != null) {
			x = p.x;
			y = p.y;
		} else {
			x = y = 0;
		}
	}

	/**
	 * getter voor x
	 * 
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * getter voor y
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * equals methode vergelijkt x en y
	 * 
	 * @param o
	 * @return
	 */
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Punt) {
			Punt p = (Punt) o;
			return x == p.x && y == p.y;
		} else {
			return false;
		}
	}

	/**
	 * Punt naar String conversie
	 * 
	 * @return Strin met waarde van x en y
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}