import javax.swing.JFrame;

/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 */

/**
 * Maakt het frame aan
 *
 */
public class RadarGUI extends JFrame {

	public static final int WIDTH = 500;
	public static final int HEIGHT = 300;

	public RadarGUI() {

		setSize(WIDTH, HEIGHT);
		setTitle("Buienradar App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
