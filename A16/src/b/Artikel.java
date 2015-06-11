package b;

public abstract class Artikel {

	public String toString() {
		return "Onbekend artikel"; 
	}

	public abstract double cost();

	public abstract double deliveryCost();

}