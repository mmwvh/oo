package b;

public class Wasmachine extends Artikel {
	
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