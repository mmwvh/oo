/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class OneDiceNplayers {

	private final Dice dice;
	private static final int PLAYERS = 2;
	private static final int THROWNS = 100;

	public OneDiceNplayers() {
		dice = new Dice();
	}

	public void play() {
		for (int i = 0; i < PLAYERS; i += 1) {
			Player p = new Player("p" + i + " ", dice, THROWNS);
			Thread t = new Thread(p);
			t.start();
		}
	}

	public static void main(String[] args) {
		OneDiceNplayers game = new OneDiceNplayers();
		game.play();
	}
}
