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
	private double xmin = -2.5;
	private double xmax = 2.5;
	private double ymax = 2.5;
	private double ymin = -2.5;
	private double s = 0;

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

				double newj = scale(grid.getHeight(), j, ymin, ymax) - ymax;
				double newi = scale(grid.getWidth(), i, xmin, xmax) - xmax;
				int m = mandelvalue(newi, newj);
				if (m % 2 == 0 || m == Integer.MAX_VALUE) {
					grid.setPixel(i, j, ColorTable.BLACK);
				} else {
					grid.setPixel(i, j, ColorTable.WHITE);
				}
			}
		}
	}
	
	public void mousePressed(double x, double y){
		setScale(x,y,this.s*2);
	}

	public void setScale(double x, double y, double scale){
		this.s = scale;
		System.out.println(grid.getHeight());
		
		double verschily = (grid.getHeight()/scale)/2; 
		double verschilx = (grid.getWidth()/scale)/2;
		
		
		this.setXmax(x+verschilx);
		this.setXmin(x-verschilx);
		this.setYmax(y+verschily);
		this.setYmin(y-verschily);
		fill();
		
	}
	
	
	private double scale(double width, double i, double min, double max) {
		double newi = 0;
		double scale = i / width;
		newi = (max - min) * scale;
		return newi;
	}

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

			if (Math.sqrt(x*x + y*y) > 2.0) {
				return n;
			}

		}

		return Integer.MAX_VALUE;
	}
	
	public void setXmin(double newxmin){
		xmin = newxmin;
	}
	
	public void setXmax(double newxmax){
		xmax = newxmax;
	}
	
	public void setYmin(double newymin){
		ymin = newymin;
	}
	
	public void setYmax(double newymax){
		ymax = newymax;
	}
}
