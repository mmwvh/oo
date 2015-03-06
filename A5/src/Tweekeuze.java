/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Tweekeuze extends Meerkeuze {

	public Tweekeuze(String v, String[] a, int j) {
		super(v, a, j);
		super.keuzes = a;
		super.antwoord = a[j];
	}

	@Override
	public String toString() {
		return vraag + " ";
	}
}
