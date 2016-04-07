/**
 * 
 */
package opg03;

import java.util.Scanner;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class Main {

	private Scanner scan = new Scanner(System.in);
	private Gallow gallow;
	private View view;

	public Main() {
		view = new View();
		start();
		game();
	}

	private void start() {
		System.out.println(view.welcome());
		int i = scan.nextInt();
		
		switch (i) {
		case 1:
			gallow = new Gallow();
			System.out.println(view.ownWord());
			break;
		case 2:
			System.out.println(view.chosenWord());
			String s = scan.next();
			gallow = new Gallow(s);
			break;
		default:
			System.out.println(view.invalidOption());
			break;
		}
	}

	private void game() {
		if (gallow.getUgly().length() > 0) {
			while (!gallow.dead()) {
				if (!gallow.won()) {
					nextEntry();
				}
				System.out.println(view.victory());
				System.out.println(view.end());
			}
			System.out.println(view.defeat(gallow.getUgly()));
			System.out.println(view.end());
		}
	}

	private void nextEntry() {
		System.out.println(view.hint(gallow.getGood()));
		System.out.println(view.bad(gallow.getBad()));
		System.out.println(view.next());
		char entry = scan.next().charAt(0);
		
		if (verify(entry)) {
			System.out.println(view.correct());
		} else
			System.out.println(view.mistake(gallow.getBad().length()));

	}

	private boolean verify(char entry) {
		if (gallow.isDuplicate(gallow.getUgly(), entry)) {
			for (int i = 0; i < gallow.getUgly().length(); i++) {
				if (entry == gallow.getUgly().charAt(i))
					gallow.setGoodChar(i, entry);
			}
			return true;
		} else if (!gallow.isDuplicate(gallow.getBad().toString(), entry)) {
			gallow.setBadChar(entry);
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main();

	}

}
