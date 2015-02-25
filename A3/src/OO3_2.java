
/**
 * 
 * @author Franka Buytenhuijs s4356845
 * @author Wesley van Hoorn s4018044
 *
 */

public class OO3_2 {

	public static final int size = 8;

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		Bord bord = new Bord();
		Positie pos = new Positie(3, 2);
		bord.start(pos, 1);

	}

}