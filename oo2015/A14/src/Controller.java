import java.util.Random;

/**
 * OO1route66 initial class
 * 
 * @author Pieter Koopman
 *
 *         The initial controller runs as a single thread
 */
public class Controller {
	public static int delay = 30; // average sleep time
	private final Model model; // the model
	private final Random random; // a random generator
	public static boolean run = true; // car can run in simulation

	/**
	 * The constructor of the controller
	 * 
	 * @param model
	 *            holds the cars
	 */
	public Controller(Model model) {
		this.model = model;
		random = new Random();
	}

	/**
	 * the run method from Thread forever: move all cars sleep some time
	 */
	public void run() {
		while (true) {
			stepAllCars();
			pause();
		}
	}

	/**
	 * wait some pseudo random time
	 */
	private void pause() {
		try { // sleep can throw an exception
			Thread.sleep(delay / 2 + random.nextInt(delay));
		} catch (InterruptedException e) { // catch the exception thrown by
											// sleep
			System.out.println("An exception in Controller: " + e);
		}
	}

	/**
	 * make one step with all cars and repaint views.
	 */
	public void stepAllCars() {
		if (run) {
			for (int c = 0; c < Model.NUMBEROFCARS; c += 1) {
				model.getCar(c).step();
			}
		}
		model.update(); // update only after all cars have stepped
	}

	/**
	 * stop all cars by setting boolean run to false
	 */
	public void stopCars() {
		run = false;
	}

	/**
	 * start all cars by setting boolean run to true
	 */
	public void resumeCars() {
		run = true;
	}

	public int getDelay() {
		return delay;
	}

	/**
	 * set delay between maximum and minimum bounds
	 * 
	 * @param d
	 */
	public void setDelay(int d) {
		delay = Math.max(50, Math.min(2000, d));
	}
}
