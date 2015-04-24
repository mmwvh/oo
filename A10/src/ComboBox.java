import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 */

public class ComboBox{
	
	/**
	 * Maakt een nieuwe combobox aan
	 */
	private JComboBox cb;
	BufferedImage img;
	private JTable table;
	private ParseXMLDOM parse = new ParseXMLDOM();
	
	public ComboBox(Controller cont){
		String[] stations = parse.getName();
		cb = new JComboBox(stations);
		cb.addActionListener(cont);
		
	}

	public JComboBox getComboBox() {
		return this.cb;
	}
	

}
