import java.util.Random;

/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Dice {
	private int pips;
	private final Random rand;
	public static final int MAX_PIPS = 6;

	public Dice() {
		rand = new Random();
	}

	/**
	 * Get a random number between 1 and 6
	 */
	public void throwDice() {
		pips = rand.nextInt(MAX_PIPS) + 1;
	}

	/**
	 * 
	 * @return the number of pips per thread
	 */
	public synchronized int readOfThrowns() {
		this.throwDice();
		return this.getPips();
	}

	public int getPips() {
		return pips;
	}
}
