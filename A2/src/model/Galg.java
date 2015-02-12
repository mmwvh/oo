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
	private int fouten = 0;

	public Galg(String s) {
		this.woord = s;
		dots();
	}

	public Galg() {

		WoordLezer wl = new WoordLezer("woorden.txt");
		woord = wl.geefWoord();
		dots();
	}

	private void dots() {
		for (int i = 0; i < woord.length(); i++) {
			geradenWoord.append('.');
		}
	}

	private boolean duplicate(StringBuilder s, char u) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == u) {
				return true;
			}
		}
		return false;
	}

	public void checkLetter(char u) {
		boolean aanpassing = false;
		for (int i = 0; i < woord.length(); i++) {
			char c = woord.charAt(i);
			if (c == u) {
				if (!duplicate(correct, u)) {
					correct.append(u);
				}
				geradenWoord.setCharAt(i, u);
				aanpassing = true;
			}
		}
		if (!aanpassing) {
			System.out.println("Deze letter zat niet in het woord");
			if (!duplicate(misser, u)) {
				misser.append(u);
				fouten++;
			}
		}
	}

	public boolean huidigeToestand() {
		System.out.println("\nDit is uw hint: ");
		System.out.println(geradenWoord);

		if (fouten == 11) {
			System.out.println("U hangt! Het juiste woord was " + woord);

			int counter = 0;
			for (int i = 0; i < woord.length(); i++) {
				if (geradenWoord.charAt(i) == '.') {
					counter++;
				}
			}
			if (counter == 0) {
				System.out
						.println("U heeft het woord geraden! Het juiste woord was inderdaad "
								+ woord);
				return true;
			} else if (counter != 0) {
				System.out
						.println("U heeft het woord nog niet geraden! U mag nog "
								+ (10 - fouten) + " fouten maken.");
				return false;
			}
			return true;
		}
		return false;
	}

}
