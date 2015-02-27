

/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public enum Direction {
	N(0, -1), Z(0, 1), O(1, 0), W(-1, 0);

	public final int dx, dy;

	private Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public Direction turnLeft() {
		switch (this) {
		case N:
			return Direction.W;
		case Z:
			return Direction.O;
		case O:
			return Direction.N;
		case W:
			return Direction.Z;
		default:
			return null;
		}
	}

	public Direction turnRight() {
		switch (this) {
		case N:
			return Direction.O;
		case Z:
			return Direction.W;
		case O:
			return Direction.Z;
		case W:
			return Direction.N;
		default:
			return null;
		}
	}
}
