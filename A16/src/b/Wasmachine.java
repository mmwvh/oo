package b;

public class Wasmachine extends Artikel {
	/**
	 *
	 * @author Franka Buytenhuijs / s4356845
	 * @author Wesley van Hoorn / s4018044
	 */
	public Wasmachine() {
		
	}

	@Override
	public String toString() {
		return "Wasmachine";
	}

	@Override
	public double cost() {
		return 499.00;
	}

	public double deliveryCost() {
		return 30.00;
	}

}