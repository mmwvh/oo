package Interface;
import Enum.Fragment;

/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public interface InfoLoipe {
	public int getX(); // grootte in oost-west richting

	public int getY(); // grootte in noord-zuid richting

	public Fragment getFragment(int x, int y); // fragment van de loipe op
												// positie(x,y)
}
