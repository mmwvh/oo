import java.util.Random;

/**
 * 
 */

/**
 * @author mmwvh
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
			// pause();
			//
			// if !Controller.run
			//	continue
			// 
			// if !canStep()
			// 	otherCar.wait()
			//	continue
			//
			// if staatVoorKruising
			//	regelaar.cross(car.dir)
			// elif verlaatKruising
			//	regelaar.leave
			//
			// step()
			// updateView()
			// notifyAll()
			pause();
			if (!Controller.run) {
				continue;
			}
			
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
			
			if (car.getLocation() < RoadView.WINDOWSIZE * 0.5 - 32 &&
					car.getLocation() + car.getSpeed() >= RoadView.WINDOWSIZE * 0.5 - 32) {
				regelaar.cross(car.getDirection());
			} else if (car.getLocation() < RoadView.WINDOWSIZE * 0.5 + 32 + Car.CARLENGTH &&
					car.getLocation() + car.getSpeed() > RoadView.WINDOWSIZE * 0.5 + 32 + Car.CARLENGTH) {
				regelaar.leave(car.getDirection());
			}
			
			car.step();
			model.update();
			synchronized (car) {
				car.notify();
			}
		}

	}

}
