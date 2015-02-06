/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 */
public class Group {

	private final int number;
	private Student[] students;

	Group(int n) {
		number = n;
		Student[] students = new Student[n];
	}

	/**
	 * 
	 * @return True als er nog ruimte is in de array; False als de array vol
	 *         zit.
	 */
	private boolean place() {
		return students.length + 1 < number;
	}

	/**
	 * Voegt student toe
	 * 
	 * @param s
	 *            = Student die dient te worden toegevoegd.
	 * 
	 */
	public void add(Student s) {
		if (place()) {
			students[students.length + 1] = s;
		}
	}
	/**
	 * 
	 * @param i
	 * @return
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
