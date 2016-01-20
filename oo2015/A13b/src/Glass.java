/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Glass {

	private int volume = 0;

	public void fill(int cc) {
		volume = cc;
	}

	public void empty() {
		volume = 0;
	}

	public int getVolume() {
		return volume;
	}
}
