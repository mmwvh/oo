package a;
public class Slagroom extends Versiersel {

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