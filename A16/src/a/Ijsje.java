package a;
public abstract class Ijsje {
	/**
	 *
	 * @author Franka Buytenhuijs / s4356845
	 * @author Wesley van Hoorn / s4018044
	 */
	private String description;

	@Override
	public String toString() {
		return "Onbekend ijsje";
	}

	/**
	 * berekent de kosten van het ijsje
	 * @return
	 */
	public abstract int cost();

	protected String getDescription() {
		return this.description;
	}

}