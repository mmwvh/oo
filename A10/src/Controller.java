import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 */

public class Controller implements ActionListener {
	
	private String stationName;
	private int stationIndex;
	private BufferedImage img;
	private JTable table;
	private ComboBox cb;
	private ParseXMLDOM parse;
	private JTextArea Infopanel;
	private RadarGUI gui;
	private JPanel picturePanel;
	public Controller(){
	
		cb = new ComboBox(this);
		parse = new ParseXMLDOM();
		makeGui();
	}
	
	/**
	 * maakt het frame en de panels aan
	 */
	public void makeGui(){
		gui = new RadarGUI();
		
		JPanel buttonPanel = new JPanel();
		Button b = new Button(this);
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(b.getButton(), BorderLayout.CENTER);
		buttonPanel.setPreferredSize(new Dimension(120,100));
		
		JPanel boxPanel = new JPanel();
		boxPanel.add(cb.getComboBox());
		gui.add(cb.getComboBox(), BorderLayout.NORTH);
		boxPanel.setVisible(true);
		
		Infopanel = new JTextArea();
		Infopanel.setLayout(new BorderLayout());
		Infopanel.setPreferredSize(new Dimension(50,50));
		Infopanel.setVisible(true);
		
		picturePanel = new JPanel();
		picturePanel.setPreferredSize(new Dimension(100,500));
		
		gui.add(buttonPanel, BorderLayout.WEST);
		gui.add(picturePanel, BorderLayout.SOUTH);
		gui.add(Infopanel, BorderLayout.CENTER);
		gui.setVisible(true);
	}
	
	
	/**
	 * ZOrgt ervoor dat het weer wordt getoond als er een plaats wordt gekozen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
			JComboBox cbw = (JComboBox)e.getSource();
	        stationName = (String)cbw.getSelectedItem();
	        stationIndex = cbw.getSelectedIndex();
	        parse.ShowWeather(stationName, stationIndex);  
	    
	        img = parse.getImage();
	        picturePanel.removeAll();
	        picturePanel.add(new JLabel(new ImageIcon(img)), BorderLayout.WEST);
	        picturePanel.repaint();
	        gui.repaint();
	        
	        Infopanel.setText("Datum: " + parse.Datum() + "\nTemperatuur: " + parse.Temperatuur()
	        		+ "\nRegen: " + parse.regen() + "\nWindsnelheid: " + parse.Windsnelheid()
	        		+ "\nWindrichting: " + parse.Windrichting());
	        
		
	}
	

}
