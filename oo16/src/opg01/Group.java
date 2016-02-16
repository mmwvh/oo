/**
 * 
 */
package opg01;

import java.util.Arrays;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class Group {

	private final int n;
	private Student[] students;

	public Group(int n) {

		this.n = n;
		this.students = new Student[n];
	}

	/**
	 * Adds Student to students
	 * 
	 * @param student
	 * @return true if it successfully added Student to students, false
	 *         otherwise
	 */
	public boolean add(Student student) {

		for (int i = 0; i < n; i++) {
			if (students[i] == null) {
				students[i] = student;
				return true;
			}
		}
		return false;
	}

	public Student getStudent(int i) {
		return students[i];
	}

	public int getSize() {
		return students.length;
	}

	/**
	 * 
	 * 
	 * @return Each Student in students as follows "Student \n"
	 */
	@Override
	public String toString() {
		String c = "";
		for (Student student : students)
			c += student + "\n";
		return c;
	}
}