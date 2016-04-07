/**
 * 
 */
package opg03;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class View {

	public View() {

	}

	public String welcome() {
		return "Welkom bij Galgje!\nWilt u een medespeler een woord laten invoeren, toets 1 \nWilt u een voorgegenereerd woord gebruiken, toets 2.";
	}

	public String ownWord() {
		return "Geef een woord in: ";
	}

	public String chosenWord() {
		return "U heeft gekozen voor een voorgegenereerd woord.";
	}

	public String invalidOption() {
		return "U heeft een verkeerde waarde ingevoerd, start opnieuw.";
	}

	public String victory() {
		return "Gefeliciteerd U heeft het woord goed geraden.\nHet programma zal nu afsluiten, bedankt voor het spelen!";
	}

	public String defeat(String s) {
		return "U heeft het woord niet kunnen raden. Het woord was: " + s + ".";
	}
	
	public String end() {
		return "Het programma zal nu afsluiten, bedankt voor het spelen!";
	}
	
	public String hint(StringBuilder s) {
		return "Dit is uw hint: " + s.toString() + ".";
	}
	
	public String bad(StringBuilder s) {
		return "Deze letters heeft u al geprobeerd maar waren fout: " + s.toString() + ".";
	}
	
	public String next() {
		return "Geef een letter in.";
	}
	
	public String correct() {
		return "Correct!";
	}
	
	public String mistake(int n) {
		return "Jammer, probeer het nog eens.\nU mag nog " + (7 - n) + " fouten maken.";
	}
}
