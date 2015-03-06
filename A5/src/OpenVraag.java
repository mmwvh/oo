/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class OpenVraag extends Vraag {

	private String antwoord;

	public OpenVraag(String v, String a) {
		super(v);
		this.antwoord = a;
	}

	@Override
	public String juisteAntwoord() {
		return antwoord;
	}

	/**
	 * 
	 * @return TRUE als het antwoord van de user matched met van het antwoord op
	 *         de vraag (hoofdletter ongevoelig). FALSE anderzijds.
	 */
	@Override
	public boolean isCorrect(String a) {
		return a.equalsIgnoreCase(juisteAntwoord());
	}
}
