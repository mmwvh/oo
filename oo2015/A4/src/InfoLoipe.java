
/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public interface InfoLoipe {
	public Punt start(); // het startpunt op de kaart

	public Punt stap(int i); // het volgende punt op de route

	public int getWidth(); // grootte in oost-west richting

	public int getHeight(); // grootte in noord-zuid richting

	public Fragment getFragment(int x, int y); // fragment van de loipe op
												// positie(x,y)
}
