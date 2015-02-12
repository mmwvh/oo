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
	boolean geraden = false;
	Galg galg;
	public View() {

		galg = new Galg();
		System.out
				.println("Welkom bij Galgje! Wilt u een medespeler een woord laten invoeren, "
						+ "toets 1.\nWilt u een voorgegenereerd woord gebruiken, toets 2: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		if (num == 1) {
			System.out.println("Geef een woord: ");
			Scanner eigen_woord = new Scanner(System.in);
			String woord = eigen_woord.nextLine();
			galg = new Galg(woord);
		} else if (num == 2) {
			galg = new Galg();
		}
		while (!geraden) {
			geraden = galg.huidigeToestand();
			if (geraden) {
				System.out
						.println("Het programma zal nu afsluiten, bedankt voor het spelen!");
				System.exit(0);
			}
			this.vraagLetter();
		}
	}

	public void vraagLetter() {
		System.out.println("Geef één letter: ");
		Scanner scan = new Scanner(System.in);
		char letter = scan.next().charAt(0);

		galg.checkLetter(letter);

	}
}
