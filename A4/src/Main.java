
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
		p = l.start();
		AsciiArt aa = new AsciiArt();
		aa.setLoipe(l);
		aa.teken();
		aa.print();
		LoipePlaatje lp = new LoipePlaatje(l);
		lp.teken();
		View view = new View();
		
		for(int i = 0; i < pad.length() + 1; i++){
			if(view.input()){
				aa.setPosition(p);
				if(i < pad.length()){
					p = l.stap(i);
				}
			}
				
		}

		
		
	}

}
