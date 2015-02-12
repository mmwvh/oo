package galgje;

import java.util.Scanner;

import model.Galg;
import interactie.Controller;

public class Hoofd {
	private boolean geraden = false;
	private Galg galg;

	public Hoofd() {

		galg = new Galg();

		while (!geraden) {
			geraden = galg.gameState();
			if (geraden) {
				System.out
						.println("Het programma zal nu afsluiten, bedankt voor het spelen!");
				System.exit(0);
			}
			this.vraagLetter();
		}
	}

}
