package b;

public class Wijnglazen extends Artikel {

	public Wijnglazen() {
		
	}
	
	@Override
	public String toString() {
		return "Wijnglazen";
	}

	@Override
	public double cost() {
		return 8.50;
	}

	@Override
	public double deliveryCost() {
		return 6.75;
	}

}