import java.util.Random;

/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Driver implements Runnable {
	private final Random random; // a random generator
	private final Model model;
	private Car car;
	private Car carif;
	private Regelaar regelaar;

	public Driver(Car c1, Car c2, Model model, Regelaar regelaar) {
		random = new Random();
		this.model = model;
		this.car = c1;
		this.carif = c2;
		this.regelaar = regelaar;
	}

	private boolean distance() {
		return (Math.abs(car.getLocation() - carif.getLocation())
				- Car.CARLENGTH - 10 >= car.getSpeed());
	}

	/**
	 * wait some time
	 */
	private void pause() {
		try { // sleep can throw an exception
			Thread.sleep(Controller.delay / 2
					+ random.nextInt(Controller.delay));
		} catch (InterruptedException e) { // catch the exception thrown by
											// sleep
			System.out.println("An exception in Controller: " + e);
		}
	}

	@Override
	public void run() {
		while (true) {

			pause();
			// Allowed to run
			if (!Controller.run) {
				continue;
			}

			// Cars keep their distance
			if (!distance()) {
				try {
					synchronized (carif) {
						carif.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}

			// Wait when the intersection is unsafe
			if (car.getLocation() < RoadView.WINDOWSIZE * 0.5 - 32
					&& car.getLocation() + car.getSpeed() >= RoadView.WINDOWSIZE * 0.5 - 32) {
				if (!regelaar.enterCross(car.getDirection())) {
					try {
						synchronized (car) {
							car.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} // Notify when the intersection is safe again
			else if (car.getLocation() < RoadView.WINDOWSIZE * 0.5 + 32
					+ Car.CARLENGTH
					&& car.getLocation() + car.getSpeed() > RoadView.WINDOWSIZE
							* 0.5 + 32 + Car.CARLENGTH) {
				if (regelaar.leftCross(car.getDirection())) {
					synchronized (car) {
						car.notifyAll();
					}
				}
			}

			car.step();
			model.update();
			synchronized (car) {
				car.notifyAll();
			}
		}

	}

}
