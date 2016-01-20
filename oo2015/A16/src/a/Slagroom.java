package a;
public class Slagroom extends Versiersel {
	/**
	 *
	 * @author Franka Buytenhuijs / s4356845
	 * @author Wesley van Hoorn / s4018044
	 */
	public Slagroom(Ijsje ijsje) {
		super(ijsje);
		
	}
	
	@Override 
	public String toString() {
		return ijsje.toString() + ", met Slagroom"; 
	}

	@Override
	public int cost() {
		return super.cost() + 50;
	}
}