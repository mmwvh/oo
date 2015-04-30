/**
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
	 * fills the whole grid with some arbitrarily chosen color
	 * 
	 */
	public void fill() {
		int grid_w = grid.getWidth(), grid_h = grid.getHeight();
		for (int i = 0; i < grid_w; i++) {
			for (int j = 0; j < grid_h; j++) {
				int m = mandelvalue(i, j);
				if (m % 2 == 0 || m == 100) {
					grid.setPixel(i, j, colorTable.BLACK);
				}
				else {
					grid.setPixel(i, j, colorTable.getColor(10));
				}
				//int color_index = i / 5 * grid_w / 5 + j / 5;
				//grid.setPixel(i, j, colorTable.getColor(color_index));
			}
		}
	}

	private int mandelvalue(int a, int b) {

		int n = 0;

		double m = 0;
		double xn = 0;
		double yn = 0;
		double x = (double) a;
		double y = (double) b;

		while (n < 100 && m < 2.0) {
			n++;

			xn = Math.pow(x, 2) - Math.pow(y, 2) + a;
			yn = 2 * x * y + b;

			x = xn;
			y = yn;

			m = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

		}

		return n;
	}
}
