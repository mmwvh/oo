package mandelbrot;
/**
*
* @author Franka Buytenhuijs / s4356845
* @author Wesley van Hoorn / s4018044
*/

/**
 * 
 * class representing a point in the gird with the coresponding color of the x and y values
 *
 */
class ColorPoint {
	private int x, y;
	private int[] color;

	public ColorPoint(int x, int y, int[] color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int[] getColor() {
		return color;
	}
}