package b;

public abstract class Betaalmiddel {
	
	private double price;
	
	public Betaalmiddel(double price) {
		this.price = price;
	}
	
	public abstract boolean pay( double price);

}