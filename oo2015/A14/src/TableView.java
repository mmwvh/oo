import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * OO14route66 initial class
 * 
 * @author Pieter Koopman
 */
public class TableView extends JFrame {
	JPanel panel;
	public static final int WINDOWWITDH = 100 * Model.DIRECTIONS,
			WINDOWHEIGTH = 200;
	JLabel[] textLabels;
	private final Model model; // for the positions of the cars

	/**
	 * The constructor of TableView
	 * 
	 * @param model
	 *            containing the position of the cars to display makes a panel
	 *            with a gridLayout and a JLabel for each car in this panel
	 */
	TableView(Model model) {
		super("Route66 table view");
		this.model = model;
		setSize(WINDOWWITDH, WINDOWHEIGTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new GridLayout(Model.NUMBEROFCARS / Model.DIRECTIONS
				+ 1, Model.DIRECTIONS));

		for (int i = 0; i < Model.DIRECTIONS; i += 1) { // make table headings
			panel.add(new JLabel(Direction.intToDirection(i).toString()));
		}

		textLabels = new JLabel[Model.NUMBEROFCARS]; // make car info
		for (int c = 0; c < Model.NUMBEROFCARS; c += 1) {
			textLabels[c] = new JLabel(label(c));
			panel.add(textLabels[c]);
		}
		add(panel);
	}

	/**
	 * update the JLabel for each car
	 * 
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int c = 0; c < Model.NUMBEROFCARS; c += 1) {
			textLabels[c].setText(label(c));
		}
	}

	/**
	 * create a label for the given car number
	 * 
	 * @param c
	 *            : car number
	 * @return string representing the car information
	 */
	private String label(int c) {
		return c + ": " + model.getCar(c).getLocation();
	}
}
