/**
 * 
 */
package opg01;

import java.util.Scanner;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class Main {

	private Scanner scan;
	private View view;
	private Group students;

	public Main() {

		scan = new Scanner(System.in);
		view = new View();

		int n = scanSize();
		students = new Group(n);
	}

	/**
	 * Fills the group and runs the group editor
	 */
	private void toDo() {
		fillGroup();
		editGroup();
	}

	/**
	 * 
	 * @return Scanned Group size
	 */
	private int scanSize() {
		System.out.println(view.size());
		return scan.nextInt();
	}

	/**
	 * 
	 * @param i
	 * @return Scanned firstname of i'th Student
	 */
	private String scanFirstname(int i) {
		System.out.println(view.name(i));
		return scan.next();
	}

	/**
	 * 
	 * @return Scanned lastname of Student
	 */
	private String scanName() {
		return scan.nextLine();
	}

	/**
	 * 
	 * @param i
	 * @return Scanned studentnumber of i'th Student
	 */
	private int scanNumber(int i) {
		System.out.println(view.number(i));
		return scan.nextInt();
	}

	/**
	 * 
	 * @param i
	 * @return Student object with scanned properties
	 */
	private Student scanStudent(int i) {
		Student s = new Student(scanFirstname(i), scanName(), scanNumber(i));
		return s;
	}

	/**
	 * Add Students to students until students is filled
	 * 
	 */
	private void fillGroup() {
		for (int i = 0; i < students.getSize(); i++)
			students.add(scanStudent(i));
		System.out.println(students);
	}

	/**
	 * Request the index of the Student to be altered and set that Student or an
	 * invalid index to exit
	 */
	private void editGroup() {
		int i = 0;

		do {
			System.out.println(view.id());
			i = scan.nextInt();

			if (i > students.getSize())
				System.out.println(view.bounds());
			else if (i >= 0) {
				Student s = students.getStudent(i);
				s.setStudent(scanFirstname(i), scanName(), scanNumber(i));
			}

			System.out.println(students);
		} while (i >= 0);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Main run = new Main();
		run.toDo();
	}

}
