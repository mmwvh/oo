package a;
public class Chocodip extends Versiersel {
	/**
	 *
	 * @author Franka Buytenhuijs / s4356845
	 * @author Wesley van Hoorn / s4018044
	 */
	
	public Chocodip(Ijsje ijsje) {
		super(ijsje);
		
	}
	
	@Override 
	public String toString() {
		return ijsje.toString() + ", met Chocodip"; 
	}

	@Override
	public int cost() {
		return super.cost() + 30;
	}
}