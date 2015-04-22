import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button {
	JButton b;

	public Button() {
		b = new JButton();
		b.setMinimumSize(new Dimension(110, 110));
		ImageIcon img = new ImageIcon(getClass().getResource("refresh.png"));
		b.setIcon(img);
	}

	public JButton getButton() {
		return this.b;
	}
}
