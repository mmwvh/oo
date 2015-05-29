import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * OO13route66 animation
 * 
 * @author Pieter Koopman
 *
 *         Yields a graphical view on all cars
 */
public class RoadView extends JFrame {
	JPanel panel; // the panel to draw the cars
	public static final int WINDOWSIZE = 600; // the window size
	private final Model model; // the model knows the position of cars

	/**
	 * A subclass of JPanel to draw the cars. This is a bit of a hack to ensure
	 * that this panel is painted correctly.
	 */
	private class CarPanel extends JPanel {
		/**
		 * Constructor: just call the constructor of the base class
		 */
		public CarPanel() {
			super();
		}

		/**
		 * paint the roads and cars
		 * 
		 * @param g
		 *            Graphics to paint on
		 */
		@Override
		public void paint(Graphics g) {
			paintRoad(g);
			paintCars(g);
		}
	}

	/**
	 * The constructor of RoadView
	 * 
	 * @param model
	 */
	RoadView(Model model) {
		super("Route66 traffic simulator");
		this.model = model;
		setSize(WINDOWSIZE, WINDOWSIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new CarPanel();
		add(panel);
	}

	/**
	 * Paint the view of the model graphically
	 * 
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		panel.repaint();
	}

	/**
	 * Paint all cars
	 * 
	 * @param g
	 *            graphics to draw on
	 */
	private void paintCars(Graphics g) {
		for (int i = 0; i < Model.NUMBEROFCARS; i += 1) {
			model.getCar(i).paint(g);
		}
	}

	/**
	 * Paint the roads
	 * 
	 * @param g
	 *            graphics to draw on
	 */
	private void paintRoad(Graphics g) {
		final int left = (WINDOWSIZE / 2) - Car.CARWIDTH - 4;
		final int width = 2 * Car.CARWIDTH + 8;
		g.setColor(Color.white); // background
		g.fillRect(0, 0, WINDOWSIZE, WINDOWSIZE);
		g.setColor(Color.darkGray); // streets
		g.fillRect(0, left, WINDOWSIZE, width);
		if (Model.DIRECTIONS > 2) { // paint a crossing if there are 4
									// directions
			g.fillRect(left, 0, width, WINDOWSIZE);
		}
	}
}
