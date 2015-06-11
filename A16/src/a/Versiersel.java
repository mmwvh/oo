package a;

import java.util.LinkedList;
import java.util.List;
/**
*
* @author Franka Buytenhuijs / s4356845
* @author Wesley van Hoorn / s4018044
*/
public class Versiersel extends Ijsje {

	protected final Ijsje ijsje;
	
	public Versiersel(Ijsje ijsje) {
		this.ijsje = ijsje;
	}
	
	@Override
	public int cost() {return ijsje.cost(); }
	
	public String toString() {
		// TODO - implement Versierder.toString
		throw new UnsupportedOperationException();
	}
	
	

}