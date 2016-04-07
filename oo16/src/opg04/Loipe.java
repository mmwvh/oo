/**
 * 
 */
package opg04;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class Loipe implements InfoLoipe {
	
	private int xmin, xmax, ymin, ymax;
	private String pad;
	private Fragment[][] loipe;
	
	public Loipe(String pad) {

	}

	public int getWidth() {
		return Math.abs(Math.abs(xmin - xmax) + 1);
	}

	public int getHeight() {
		return Math.abs(Math.abs(ymin - ymax) + 1);
	}

	public Fragment getFragment(Punt p) {
		return (loipe[p.getX()][p.getY()]);
	}

	public Punt start() {
		return new Punt();
	}

	public Punt stap() {
		// TODO Auto-generated method stub
		return new Punt();
	}

}
