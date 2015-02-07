/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 *         Klasse voor het aanmaken van Student objecten.
 */
public class Student {

	private String firstName; // Voornaam.
	private String name; // Achternaam.
	private int studentNr; // Student nummer.

	Student(String fn, String n, int nr) {
		firstName = fn;
		name = n;
		studentNr = nr;
	}

	/**
	 * Wijzigd studentnaam
	 * 
	 * @param new_fn
	 *            = nieuwe voornaam
	 * @param new_n
	 *            = nieuwe achternaam
	 */
	public void setName(String new_fn, String new_n) {
		this.firstName = new_fn;
		this.name = new_n;
	}

	/**
	 * toString() override
	 * 
	 * @return string in de vorm: "Voornaam achternaam, s1234567".
	 */
	@Override
	public String toString() {
		return this.firstName + " " + this.name + ", s" + this.studentNr + "\n";
	}
}
