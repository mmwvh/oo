import java.awt.Insets;

import javax.swing.JFrame;

/**
 * 
 * @author Sjaak Smetsers
 * @version 1.0, 14-03-2013
 */

/**
 * creates a window to which a GridView panel is added
 * 
 */
public class MainWindow {
	// the size of the window
	public static final int WIDTH = 650, HEIGHT = 650;

	// The grip panel
	private GridView grid;
	private GridFiller gf;
	private MouseHandler mh;
	JFrame mainFrame;

	public MainWindow() {
		mainFrame = new JFrame("Mandelbrot");
		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		Insets insets = mainFrame.getInsets();
		grid = new GridView(WIDTH - insets.left - insets.right, HEIGHT
				- insets.top - insets.bottom);
		mainFrame.add(grid);
		mainFrame.pack();

	}

	/**
	 * A getter for the grid
	 * 
	 * @return the grid
	 */
	public Grid getGrid() {
		return grid;
	}

	public void setFiller(GridFiller gf) {
		this.gf = gf;
		MouseHandler mh = new MouseHandler(gf);
		grid.addMouseListener(mh);
		grid.addMouseMotionListener(mh);
	}

}
