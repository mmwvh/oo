/**
 * 
 */
package opg04;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public interface InfoLoipe {
	public int getWidth();
	public int getHeight();
	public Fragment getFragment(Punt p);
	
	public Punt start();
	public Punt stap();
}
