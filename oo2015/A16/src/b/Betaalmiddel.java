package b;
/**
*
* @author Franka Buytenhuijs / s4356845
* @author Wesley van Hoorn / s4018044
*/
public abstract class Betaalmiddel {
	
	private double price;

	public Betaalmiddel(double price) {
		this.price = price;
	}
	
	/**
	 * vraagt gegevens van de gebruiker om de betalen met succes af te ronden.
	 * @param price
	 * @return
	 */
	public abstract boolean pay( double price);

}