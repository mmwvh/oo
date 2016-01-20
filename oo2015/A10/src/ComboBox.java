import java.awt.image.BufferedImage;

import javax.swing.JComboBox;

/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 */

public class ComboBox {

	/**
	 * Maakt een nieuwe combobox aan
	 */
	private JComboBox cb;
	BufferedImage img;
	private ParseXMLDOM parse = new ParseXMLDOM();

	public ComboBox(Controller cont) {
		String[] stations = parse.getName();
		cb = new JComboBox(stations);
		cb.addActionListener(cont);

	}

	public JComboBox getComboBox() {
		return this.cb;
	}

}
