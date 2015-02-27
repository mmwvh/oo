
/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pad = "srssrsslsllsss";
		Punt p = new Punt(0,0);
		Loipe l = new Loipe(pad);
		AsciiArt aa = new AsciiArt();
		aa.setLoipe(l);
		aa.teken();
		aa.print();
		aa.setPosition(p);
		LoipePlaatje lp = new LoipePlaatje(l);
		lp.teken();
		
		
	}

}
