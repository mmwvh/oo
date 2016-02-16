/**
 * 
 */
package opg02;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class Pos {

	private int x, y;

	public Pos(int x, int y) {
		setX(x);
		setY(y);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
