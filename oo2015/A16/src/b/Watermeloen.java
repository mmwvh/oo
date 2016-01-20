package b;

public class Watermeloen extends Artikel {
	/**
	 *
	 * @author Franka Buytenhuijs / s4356845
	 * @author Wesley van Hoorn / s4018044
	 */
	public Watermeloen() {
		
	}
	
	@Override
	public String toString() {
		return "Watermeloen"; 
	}

	@Override
	public double cost() {
		return 4.50;
	}

	@Override
	public double deliveryCost() {
		return 6.75;
	}

}