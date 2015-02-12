/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 **/

package oo15opg02galgje;

public class Galg {

	Galg(String s) {

	}

	Galg() {

		WoordLezer w = new WoordLezer("woorden.txt");
		String woord = w.geefWoord();
		
		System.out.print( woord);

	}

}
