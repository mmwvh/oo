/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Player implements Runnable {

	private final Dice dice;
	private final String name;
	private final int numberOfThrowns;

	public Player(String name, Dice dice, int numberOfThrowns) {
		this.name = name;
		this.dice = dice;
		this.numberOfThrowns = numberOfThrowns;
	}

	@Override
	public void run() {
		for (int i = 0; i < numberOfThrowns; i += 1) {
			int pips = dice.readOfThrowns();
			System.out.println(name + "throws " + pips + " in turn " + i);
		}

	}

}
