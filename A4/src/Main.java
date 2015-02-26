import Draw.AsciiArt;

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
		String pad = "srsssssrsslsssllssssss";
		Loipe L = new Loipe(pad);
		AsciiArt ascii = new AsciiArt();
		ascii.setLoipe(L);
		
		
	}

}
