import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RadarGUI extends JFrame {

	public static final int WIDTH = 500;
	public static final int HEIGHT = 700;
	

	public RadarGUI() {

		super();
		setSize(WIDTH, HEIGHT);
		setTitle("Buienradar App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		add(p);
		
		p.setLayout(new BorderLayout());
		Button b = new Button();
		p.add(b.getButton(), BorderLayout.SOUTH);
		ComboBox cb = new ComboBox();
		add(cb.getComboBox(), BorderLayout.NORTH);
	}
	
	
	
	

}
