import java.util.Scanner;

/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 *         Hoofdklasse, deze klasse voert alle taken uit en wordt aangeroepen in
 *         main.
 */
public class Head {

	Group students = null;

	Head() {
		int i = 1;
		int n = sizeAsk();
		students = new Group(n);
		fill(n);
		print(n);
		while (i >= 1) {
			i = change(n, i);
			if ( i > n){
				System.out.println("This member id does not exist, please try again.");
			}
		}

	}

	/**
	 * 
	 * @return Gegeven input integer.
	 */
	private int intScan() {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		return input;
	}

	/**
	 * 
	 * @return Gegeven input string.
	 */
	private String strScan() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		return input;
	}

	/**
	 * 
	 * @return Gewenste groep grootte.
	 */
	private int sizeAsk() {
		System.out.print("How many students are there in this group? \n");
		int n = intScan();
		return n;
	}

	/**
	 * Laat de gebruiker de n grote groep invullen.
	 * 
	 * @param n
	 *            = groep grootte
	 */
	private void fill(int n) {
		for (int i = 0; i < n; i++) {

			System.out
					.print("\nEnter first name of student " + (i + 1) + ".\n");
			String firstname = strScan();

			System.out.print("Enter last name of student " + (i + 1) + ".\n");
			String lastname = strScan();

			System.out.print("Enter student number of student " + (i + 1)
					+ ".\n");
			int studentnr = intScan();

			Student student = new Student(firstname, lastname, studentnr);
			students.add(student);

		}
		System.out.print("\nThe group is now filled.\n");
	}

	/**
	 * Print de inhoud van de n grote groep.
	 * 
	 * @param n
	 *            = groep grootte
	 */
	private void print(int n) {
		System.out.print("\nThis group has " + n + " students.\n");
		students.print();
	}

	/**
	 * Laat de gebruiker een naam van een student, uit de groep met bepaald
	 * lidnummer, aanpassen totdat de gebruiker een negatief lidnummer invoert.
	 * 
	 * @param n
	 *            = groep grootte
	 */
	private int change(int n, int i) {

		System.out
				.print("\nPlease enter the member id of student you wish to rename.\n");
		i = intScan();
		if (i > 0 && i <= n) {
			Student student = students.getStudent(i - 1);

			System.out.print("Enter a new first name of student" + i + ".\n");
			String firstname = strScan();

			System.out.print("Enter a new last name of student" + i + ".\n");
			String lastname = strScan();

			student.setName(firstname, lastname);
			this.print(n);
		}
		return i;
	}
}