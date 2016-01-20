/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class ParchedMan implements Runnable {

	private final int id;
	private static final int DRINK_TIME_PER_CC = 5;
	private static final int NUMBER_OF_GLASSES_TO_DRINK = 3;
	private static final int DIGEST_TIME = 10;
	private int numberOfGlassesDrunk = 0;
	private static Bar bar;
	private static Tap tap;

	public ParchedMan(int id, Bar bar, Tap tap) {
		this.id = id;
		this.bar = bar;
		this.tap = tap;
	}

	/**
	 * Thy actions of one man being a man
	 */
	public void drawAndDrink() {
		while (!satisfied()) {
			Glass glass = bar.readGlasses();
			if (glass != null) {
				glass = tap.fillUp(glass);
				try {
					System.out.println("Man " + id
							+ " drinks a glass of scotch");
					Thread.sleep(glass.getVolume() * DRINK_TIME_PER_CC);
				} catch (InterruptedException e) {
				}
				glass.empty();
				numberOfGlassesDrunk++;
				bar.putGlass(glass);

				try {
					Thread.sleep(DIGEST_TIME);
				} catch (InterruptedException e) {
				}
			} else {
				try {
					Thread.sleep(DIGEST_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Man " + id + " is satisfied");
	}

	private boolean satisfied() {
		return numberOfGlassesDrunk == NUMBER_OF_GLASSES_TO_DRINK;
	}

	@Override
	public void run() {
		this.drawAndDrink();
	}
}
