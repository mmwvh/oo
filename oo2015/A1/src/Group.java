/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 *         Klasse voor het aanmaken van Group objecten, deze groepen bestaan uit
 *         Student objecten.
 */
public class Group {

	private final int number;
	private Student[] students = null;

	Group(int n) {
		this.number = n; // Groep grootte.
		this.students = new Student[n]; // Array van studenten.
	}

	/**
	 * Voegt Student s toe aan de array studenten mits de array nog ruimte
	 * heeft.
	 * 
	 * @param s
	 *            = Student object
	 * @return True als s succesvol is toegevoegd; False anderzijds.
	 */
	public boolean add(Student s) {

		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = s;
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param i
	 *            = opgevraagde index waarde
	 * @return Student corresponderend aan de index waarde
	 */
	public Student getStudent(int i) {
		if (students[i] != null) {
			return students[i];
		}
		return null;
	}

	/**
	 * Print de array studenten; één student per regel.
	 */
	public void print() {
		for (int i = 0; i < number; i++) {
			System.out.print("De student " + students[i]);
		}
	}
}
