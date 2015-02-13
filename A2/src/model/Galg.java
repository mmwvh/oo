/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 **/

package model;

public class Galg {

	private String woord;
	private StringBuilder misser = new StringBuilder();
	private StringBuilder correct = new StringBuilder();
	private StringBuilder geradenWoord = new StringBuilder();

	public Galg(String s) {
		this.woord = s;
		dots();
	}

	public Galg() {

		WoordLezer wl = new WoordLezer("woorden.txt");
		woord = wl.geefWoord();
		dots();
	}

	/**
	 * Vult initiëel de StringBuilder geradenWoord met dots gelijk aan de woord
	 * lengte van het te raden woord.
	 */
	private void dots() {
		for (int i = 0; i < woord.length(); i++) {
			geradenWoord.append('.');
		}
	}

	/**
	 * 
	 * @param s
	 *            De meegegeven StringBuilder misser of correct
	 * @param u
	 *            De input character van de user
	 * @return TRUE als u al voorkomt in de meegegeven StringBuilder; FALSE als
	 *         dat niet het geval is.
	 */
	private boolean duplicate(StringBuilder s, char u) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == u) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Vervangt, mits u onderdeel is van woord, de dot door u op de correcte
	 * indexwaarde in geradenWoord. Daarnaast worden ook al de gebruikte letters
	 * opgeslagen voor statistieken.
	 * 
	 * @param u
	 *            De input character van de user
	 */
	public boolean checkLetter(char u) {
		boolean aanpassing = false;
		char c;
		for (int i = 0; i < woord.length(); i++) {
			c = woord.charAt(i);
			if (c == u) {
				if (!duplicate(correct, u)) {
					correct.append(u);
				}
				geradenWoord.setCharAt(i, u);
				aanpassing = true;

			}
		}
		if (!aanpassing) {
			if (!duplicate(misser, u)) {
				misser.append(u);
			}
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @return TRUE als er 10 fouten zijn gemaakt; FALSE anderzijds.
	 */
	public boolean dead() {
		if (!(misser.length() < 10)) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return TRUE als het woord geraden is; False anderzijds.
	 */
	public boolean gameState() {
		if (geradenWoord.toString().equals(woord)) {
			return true;
		}
		return false;
	}

	public String getW() {
		return this.woord;
	}

	public String getGW() {
		return this.geradenWoord.toString();
	}

	public String getM() {
		return this.misser.toString();
	}

}
