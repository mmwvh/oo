import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTable;

public class ComboBox implements ActionListener{
	private JComboBox cb;
	private String stationName;
	private ParseXMLDOM parse = new ParseXMLDOM();
	
	public ComboBox() {
		
		ParseXMLDOM w = new ParseXMLDOM();
		String[] stations = w.getName();
		cb = new JComboBox(stations);
		cb.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		JComboBox cbw = (JComboBox)e.getSource();
        stationName = (String)cbw.getSelectedItem();
        int stationIndex = cbw.getSelectedIndex();
        parse.ShowWeather(stationName, stationIndex);
        JTable table = parse.getTable();
        
	}

	public JComboBox getComboBox() {
		return this.cb;
	}
}
