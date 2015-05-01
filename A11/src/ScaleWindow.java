import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScaleWindow implements ActionListener  {
	public static final int WIDTH = 200, HEIGHT = 120;
	private JTextField scalefactor;
	private JTextField xcenter;
	private JTextField ycenter;
	private TextPrompt scaletext;
	private TextPrompt xtext;
	private TextPrompt ytext;
	private JButton b;
	private GridFiller gf;

	public ScaleWindow(GridFiller gf) {

		this.gf = gf;
		JFrame scaleFrame = new JFrame("Scale");

		scaleFrame.setSize(WIDTH, HEIGHT);
		scaleFrame.setLocationRelativeTo(null);
		scaleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scaleFrame.setResizable(false);
		scaleFrame.setLayout(new BorderLayout());

		b = new JButton("Apply");
		b.setMinimumSize(new Dimension(50, 50));
		scaleFrame.add(b, BorderLayout.SOUTH);
		b.addActionListener(this);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		scaleFrame.add(panel, BorderLayout.NORTH);

		scalefactor = new JTextField();
		scaletext = new TextPrompt("Scale factor", scalefactor);
		ycenter = new JTextField();
		ytext = new TextPrompt("Y coordinate of the center", ycenter);
		xcenter = new JTextField();
		xtext = new TextPrompt("X coordinate of the center", xcenter);
		panel.add(scalefactor, BorderLayout.NORTH);
		panel.add(ycenter, BorderLayout.SOUTH);
		panel.add(xcenter, BorderLayout.CENTER);
		panel.setVisible(true);
		scaleFrame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double sf = Double.parseDouble(scalefactor.getText());
		double y = Double.parseDouble(ycenter.getText());
		double x = Double.parseDouble(xcenter.getText());

		gf.setScale(x, y, sf);

	}
	
	public void setTextFields(double x, double y, double scale){
		scalefactor.setText(Double.toString(scale));
		ycenter.setText(Double.toString(y));
		xcenter.setText(Double.toString(x));
	}
	
	

}
