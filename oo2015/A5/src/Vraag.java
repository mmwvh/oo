/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public abstract class Vraag {

	protected final String vraag;

	public Vraag(String v) {
		this.vraag = v;
	}

	@Override
	public String toString() {
		return vraag + " ";
	}

	/**
	 * 
	 * @return Het correcte antwoord op de vraag.
	 */
	public abstract String juisteAntwoord();

	/**
	 * 
	 * @param a
	 * @return TRUE als het antwoord van de user gelijk is aan het antwoord van
	 *         de vraag. FALSE anderzijds.
	 */
	public abstract boolean isCorrect(String a);

}
