/**
 * 
 */
package opg01;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class Student {

	private String firstname, name;
	private int number;

	public Student(String firstname, String name, int number) {

		this.setStudent(firstname, name, number);
	}

	/**
	 * Sets Student properties
	 * 
	 * @param firstname
	 * @param name
	 * @param number
	 */
	public void setStudent(String firstname, String name, int number) {
		this.firstname = firstname;
		this.name = name;
		this.number = number;
	}

	/**
	 * @return "{first name} {last name}, {student number}"
	 */
	@Override
	public String toString() {
		return firstname + " " + name + ", s" + number;
	}

}
