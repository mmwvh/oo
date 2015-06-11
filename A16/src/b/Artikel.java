package b;
/**
*
* @author Franka Buytenhuijs / s4356845
* @author Wesley van Hoorn / s4018044
*/
public abstract class Artikel {

	public String toString() {
		return "Onbekend artikel"; 
	}

	/**
	 * returnt de kosten van een artikel
	 * @return
	 */
	public abstract double cost();

	/**
	 * returnt de bezorgkosten van een bepaald artikel
	 * @return
	 */
	public abstract double deliveryCost();

}