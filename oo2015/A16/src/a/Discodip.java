package a;
public class Discodip extends Versiersel {
	/**
	 *
	 * @author Franka Buytenhuijs / s4356845
	 * @author Wesley van Hoorn / s4018044
	 */
	public Discodip(Ijsje ijsje) {
		super(ijsje);

	}

	@Override
	public String toString() {
		return ijsje.toString() + ", met Discodip";
	}
}