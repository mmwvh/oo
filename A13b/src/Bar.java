import java.util.ArrayList;
import java.util.List;

/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Bar {

	private final Tap tap;
	private final List<Glass> glasses;
	private final List<ParchedMan> drinkers;
	
	public Bar(int numberOfGlasses) {
		tap = new Tap();
		glasses = new ArrayList<>();
		for (int i = 0; i < numberOfGlasses; i++) {
			glasses.add(new Glass());
		}
		drinkers = new ArrayList<>();
	}
	
	public void letInGuests(int number) {
		for (int i = 0; i < number; i += 1) {
			drinkers.add(new ParchedMan(i, this, tap));
		}
	}
	
	public void startDrinking() {
		for (ParchedMan man : drinkers) {
			
			Thread t = new Thread(man);
			t.start();
		}
	}
	
	public boolean areThereGlasses() {
		return glasses.size() > 0;
	}
	
	/**
	 * Reads the number of available glasses and return a glass that is not in use.
	 * @return
	 */
	public synchronized Glass readGlasses() {
		if (areThereGlasses()) {
			return getGlass();
		}
		else {
			return null;
		}
	}
	
	public Glass getGlass() {
		return glasses.remove(0);
	}
	
	public void putGlass(Glass glass) {
		glasses.add(glass);
	}
	
	public static void main(String[] args) {
		Bar bar = new Bar(2);
		bar.letInGuests(5);
		bar.startDrinking();
	}
}
