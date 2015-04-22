import java.net.URL;

import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseXMLDOM {
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private Document doc;
	private String[] name;
	private JTable table; 

	public ParseXMLDOM() {
		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			doc = db.parse(new URL("http://xml.buienradar.nl/").openStream());

			doc.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Weerstation();
	}

	private void Weerstation() {
		try {
			NodeList items = doc.getElementsByTagName("weerstation");
			name = new String[items.getLength()];
			for (int i = 0; i < items.getLength(); i++) {
				Node n = items.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) n;

					name[i] = e.getElementsByTagName("stationnaam").item(0)
							.getTextContent();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ShowWeather(String station, int index){
		String[] columnNames = {"Datum", "Temperatuur", "Windsnelheid", "Windrichting", "Luchtvochtigheid", "Regen in mm per uur"};
		try {
			NodeList items = doc.getElementsByTagName("weerstation");
				Node n = items.item(index);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) n;

					String datum = e.getElementsByTagName("datum").item(0)
							.getTextContent();
					String Temperatuur = e.getElementsByTagName("temperatuurGC").item(0)
							.getTextContent();
					String Windsnelheid = e.getElementsByTagName("windsnelheidMS").item(0)
							.getTextContent();
							
					String Windrichting = e.getElementsByTagName("windrichting").item(0)
							.getTextContent();
					
					String Luchtvochtigheid = e.getElementsByTagName("luchtvochtigheid").item(0)
							.getTextContent();
					
					String Regen = e.getElementsByTagName("regenMMPU").item(0)
							.getTextContent();
					
					Object[][] data = {{datum, Temperatuur, Windsnelheid, Windrichting, Luchtvochtigheid, Regen}};
					table = new JTable(data, columnNames);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public JTable getTable() {
		return table;
	}
	

	
	public String[] getName() {
		return this.name;
	}

}
