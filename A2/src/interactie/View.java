/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 **/

package interactie;

import java.util.Scanner;

import model.Galg;

public class View {
	private boolean geraden = false;
	private Galg galg;

	public View() {

		galg = new Galg();

		System.out
				.println("Welkom bij Galgje!\nWilt u een medespeler een woord laten invoeren, "
						+ "toets 1;\nWilt u een voorgegenereerd woord gebruiken, toets 2. ");

		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		// User kiest voor een zelf ingevoerd woord
		if (num == 1) {
			System.out.println("Geef een woord:");
			Scanner eigen_woord = new Scanner(System.in);
			String woord = eigen_woord.nextLine();
			galg = new Galg(woord);

		}
		// User kiest voor een voorgegenereerd woord
		else if (num == 2) {
			System.out
					.println("U heeft gekozen voor een voorgegenereerd woord.");
			galg = new Galg();
		}
		// Zolang het spel nog niet gewonnen is
		while (!geraden) {

			geraden = galg.gameState();
			if (geraden) {
				System.out
						.println("Gefeliciteerd U heeft het woord goed geraden.\nHet programma zal nu afsluiten, bedankt voor het spelen!");
				System.exit(0);
			} else if (galg.dead()) {
				System.out
						.println("U heeft het woord niet kunnen raden. Het woord was: "
								+ galg.getW());
				System.out
						.println("Het programma zal nu afsluiten, bedankt voor het spelen!");
				System.exit(0);
			}
			System.out.println("Dit is uw hint: " + galg.getGW());
			this.vraagLetter();
		}
	}

	/**
	 * Vraagt een letter van de user en geeft feedback over deze handeling.
	 */
	private void vraagLetter() {
		if (galg.getM().length() > 0) {
			System.out
					.println("Deze letters heeft u al geprobeerd maar waren fout: "
							+ galg.getM());
		}
		System.out.println("Geef één letter.");
		Scanner scan = new Scanner(System.in);
		char letter = scan.next().charAt(0);

		if (galg.checkLetter(letter)) {
			System.out.println("Deze letter zit in het woord.");
		} else {
			System.out.println("Deze letter zit niet in het woord. U mag nog "
					+ (10 - galg.getM().length()) + " fouten maken.");
		}

	}

}
