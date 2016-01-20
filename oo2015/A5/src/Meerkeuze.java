/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Meerkeuze extends Vraag {

	protected String antwoord;
	protected String[] keuzes;
	private StringBuilder builder = new StringBuilder();

	public Meerkeuze(String v, String[] a, int j) {
		super(v);
		this.keuzes = a;
		this.antwoord = String.valueOf(j + 1);
	}

	/**
	 * 
	 * @return StringBuilder van antwoordmogelijkheden met goede layout
	 */
	private StringBuilder keuzes() {
		builder.delete(0, builder.length());
		for (String a : keuzes) {
			builder.append("   " + a + "\n");
		}
		return builder;
	}

	@Override
	public String toString() {
		return vraag + "\n" + keuzes();
	}

	@Override
	public String juisteAntwoord() {
		return antwoord;
	}

	/**
	 * 
	 * @return TRUE als de antwoordoptie van de user matched met de indexwaarde
	 *         van het antwoord op de vraag (hoofdletter ongevoelig). FALSE
	 *         anderzijds.
	 */
	@Override
	public boolean isCorrect(String a) {
		return a.equalsIgnoreCase(juisteAntwoord());
	}
}
