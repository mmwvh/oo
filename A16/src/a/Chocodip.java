package a;
public class Chocodip extends Versiersel {

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