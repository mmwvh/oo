import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 */

public class ParseXMLDOM {
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private Document doc;
	private String[] name;
	private String Temperatuur;
	private String Datum;
	private String Windsnelheid;
	private String Windrichting;
	private String Regen;
	private BufferedImage img;

	public ParseXMLDOM() {
		try {
			dbf = DocumentBuilderFactory.newInstance();
			db = dbf.newDocumentBuilder();
			doc = db.parse(new URL("http://xml.buienradar.nl/").openStream());

			doc.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		weerStation();
	}

	/**
	 * leest de stationsnamen uit de XML uit
	 */
	private void weerStation() {
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

	/**
	 * leest de info van het station op de index "index" in het bestand uit
	 * 
	 * @param station
	 * @param index
	 */
	public void ShowWeather(String station, int index) {

		try {
			NodeList items = doc.getElementsByTagName("weerstation");
			Node n = items.item(index);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) n;

				Datum = e.getElementsByTagName("datum").item(0)
						.getTextContent();
				Temperatuur = e.getElementsByTagName("temperatuurGC").item(0)
						.getTextContent();
				Windsnelheid = e.getElementsByTagName("windsnelheidMS").item(0)
						.getTextContent();

				Windrichting = e.getElementsByTagName("windrichting").item(0)
						.getTextContent();

				Regen = e.getElementsByTagName("regenMMPU").item(0)
						.getTextContent();

				String plaatje = e.getElementsByTagName("icoonactueel").item(0)
						.getTextContent();
				URL imageURL = new URL(plaatje);
				img = ImageIO.read(imageURL);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public BufferedImage getImage() {
		return img;
	}

	public String Windsnelheid() {
		return Windsnelheid;
	}

	public String regen() {
		return Regen;
	}

	public String Datum() {
		return Datum;
	}

	public String Temperatuur() {
		return Temperatuur;
	}

	public String Windrichting() {
		return Windrichting;
	}

	public String[] getName() {
		return this.name;
	}

}
