/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 **/

package model;


public class Galg {

	Galg(String s) {

		// Stringbuilder die zo groot is als de string woord gevuld met ". "
		// Bij goed geraden letter worden de corresponderende indexwaarden vervangen
		// Zodra de Stringbuilder geen ". " meer bevat heeft de speler het spel gewonnen (of strcompare)
		// Een foute letter wordt toegevoegd aan een array[10] de inhoud wordt geprint en als deze array vol zit eindigd het spel en heeft de speler verloren
	}

	public Galg() {

		WoordLezer w = new WoordLezer("woorden.txt");
		String woord = w.geefWoord();
		
		System.out.print( woord);

	}

}
