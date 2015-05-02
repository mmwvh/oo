/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 *
 * @author Sjaak Smetsers
 ** @version 1.0, 13-03-2013
 */

/**
 * A skeleton class illustrating the use of the grid interface
 * 
 */
public class GridFiller {
	private Grid grid; // the grid to be filled
	private ColorTable colorTable; // a table for converting indexes to
									// rgb values

	private double xmid = 0;
	private double ymid = 0;
	private double s = 100;
	private ScaleWindow sw;

	/**
	 * The constructor
	 * 
	 * @param grid
	 *            to be filled
	 */
	public GridFiller(Grid grid) {
		colorTable = new ColorTable(20); // some random value, needs to be
											// adjusted
		this.grid = grid;
	}

	/**
	 * fills the whole grid with a chosen color dependant of the mandelvalue
	 * 
	 */
	public void fill() {
		int grid_w = grid.getWidth(), grid_h = grid.getHeight();
		for (int i = 0; i < grid_w; i++) {
			for (int j = 0; j < grid_h; j++) {

				double newj = scale(j, grid_h, -ymid);
				double newi = scale(i, grid_w, xmid);
				int m = mandelvalue(newi, newj);
				grid.setPixel(i, j, colorTable.getColor(m));
			}
		}
	}

	/**
	 * On mouse pressed, scale to new level.
	 * 
	 * @param x
	 *            axis mouse coordinate
	 * @param y
	 *            axis mouse coordinate
	 * @param zoom
	 *            bool in or out
	 */
	public void mousePressed(double x, double y, boolean zoom) {
		x = scale(x, grid.getWidth(), this.xmid);
		y = scale(y, grid.getHeight(), -this.ymid);
		if (zoom) {
			setScale(x, y, this.s * 2);
			sw.setTextFields(x, y, this.s);
		} else {
			setScale(x, y, this.s / 2);
			sw.setTextFields(x, y, this.s);
		}

	}

	/**
	 * sets new center with the corresponding scale
	 * 
	 * @param x
	 *            axis of mouse coordinate
	 * @param y
	 *            axis of mouse coordinate
	 * @param scale
	 */
	public void setScale(double x, double y, double scale) {
		this.s = scale;
		this.xmid = x;
		this.ymid = -y;
		fill();
	}

	/**
	 * calculate scale
	 * 
	 * @param x axis parameter 
	 * @param w length parameter
	 * @param mid center coordinate parameter
	 * @return
	 */
	private double scale(double x, double w, double mid) {

		x = (x - (0.5 * w)) / this.s + mid;

		return x;
	}

	/**
	 * calculate Mandelvalue
	 * 
	 * @param a
	 * @param b
	 * @return mandelvalue
	 */
	private int mandelvalue(double a, double b) {
		if (Math.sqrt(a * a + b * b) > 2.0) {
			return 0;
		}
		int n = 0;

		double xn = 0;
		double yn = 0;
		double x = a;
		double y = b;

		while (n < 100) {

			n++;

			xn = Math.pow(x, 2) - Math.pow(y, 2) + a;
			yn = 2 * x * y + b;

			x = xn;
			y = yn;

			if (Math.sqrt(x * x + y * y) > 2.0) {
				return n;
			}

		}

		return Integer.MAX_VALUE;
	}

	public void setScaleWindow(ScaleWindow sw) {
		this.sw = sw;
	}

}
