/**
 * 
 */
package opg01;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class View {

	public View() {

	}

	/**
	 * 
	 * @return User question group size
	 */
	public String size() {
		return "How many students are there in this group? ";
	}

	/**
	 * 
	 * @return User question students index
	 */
	public String id() {
		return "Enter a member id of a student you wish to edit or enter a false id to exit: ";
	}

	/**
	 * 
	 * @return User feedback out of bounds error
	 */
	public String bounds() {
		return "Error, member id out of bounds, please try again. ";
	}

	/**
	 * 
	 * @param i
	 * @return User question Student first and last name
	 */
	public String name(int i) {
		return "Enter name of student " + i + ": ";
	}

	/**
	 * 
	 * @param i
	 * @return User question Student student number
	 */
	public String number(int i) {
		return "Enter student number: ";
	}
}
