/**
 * 
 */
package opg04;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public enum Richting {
	N(0, -1), E(1, 0), S(0, 1), W(-1, 0);

	public final int dx, dy;

	private Richting(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public Richting turnLeft() {
		switch (this) {
		case N:
			return Richting.W;
		case E:
			return Richting.N;
		case S:
			return Richting.E;
		case W:
			return Richting.S;
		default:
			return null;
		}
	}

	public Richting turnRight() {
		switch (this) {
		case N:
			return Richting.E;
		case E:
			return Richting.S;
		case S:
			return Richting.W;
		case W:
			return Richting.N;
		default:
			return null;
		}
	}
}
