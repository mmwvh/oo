/**
 * Object Orientation
 * Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Student {

	private String firstName;
	private String name;
	private int studentNr;
	
	Student( String fn, String n, int nr ) {
		fn = firstName;
		n = name;
		nr = studentNr;
		
		Student bob = new Student( "Bob", "de Vries", 7 );
		
		System.out.print( "De student" + bob );
		setName( String fn, String n );
		
		bob.setName( "Bob", "de Bouwer");
	}
}
