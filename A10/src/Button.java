import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 */

public class Button implements ActionListener{
	JButton b;
	Controller cont;
	ParseXMLDOM parse = new ParseXMLDOM();
	/**
	 * Maakt een nieuwe refresh Button aan
	 * @param cont
	 */
	public Button(Controller cont) {
		b = new JButton();
		b.setMinimumSize(new Dimension(110, 110));
		ImageIcon img = new ImageIcon(getClass().getResource("refresh.png"));
		b.setIcon(img);
		b.setPreferredSize(new Dimension(20,100));
		this.cont = cont;
	}

	public JButton getButton() {
		return this.b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cont.actionPerformed(e);
		
	}
	
	
}
