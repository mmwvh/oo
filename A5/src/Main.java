import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Main {

	private List<Vraag> vragen = new LinkedList<Vraag>();
	Quiz quiz = new Quiz(vragen);

	public static void main(String[] args) {
		Main main = new Main();

	}

	/**
	 * Initialiseerd de vragenlijst en start het spel
	 */
	private Main() {
		vulOpen();
		vulMeer();
		vulTwee();
		Collections.shuffle(vragen);
		quiz.run();
	}

	/**
	 * Vult de vragenlijst met openvragen.
	 */
	private void vulOpen() {
		vragen.add(new OpenVraag("Wat is de complexiteit van binair zoeken?",
				"O(log N)"));
		vragen.add(new OpenVraag(
				"Hoeveel constructoren je minstens maken bij een klasse in Java?",
				"0"));
	}

	/**
	 * Vult de vragenlijst met meerkeuze vragen.
	 */
	private void vulMeer() {
		vragen.add(new Meerkeuze(
				"Wat is de complexiteit van slim in situ sorteren?",
				new String[] { "O(N^2)", "O(N log N)", "O(N)", "O(log N)" }, 1));
		vragen.add(new Meerkeuze(
				"Hoe print je \"Hello world\" op een regel in Java?",
				new String[] { "System.out.print(\"Hello world\");",
						"System.out.println(\"Hello world\");",
						"cout << \"Hello world\";" }, 1));
		vragen.add(new Meerkeuze(
				"Hoe lees je in Java een niet leeg woord uit scanner s?",
				new String[] { "s.nextline()", "s.next(\"\\S+\")",
						"s.next(\"\\a*\")", "s.next(\"\\S*\")",
						"s.next(\"\\\\s+\")", "s.next(\"\\s+\")",
						"s.nextString(\"\\s*\")", "s.next(\"\\\\S+\")",
						"s.nextString()" }, 7));
	}

	/**
	 * Vult de vragenlijst met tweekeuze vragen.
	 */
	private void vulTwee() {
		vragen.add(new Tweekeuze("V of G; Hoe wordt deze opdracht beoordeeld?",
				new String[] { "G", "V" }, 0));
		vragen.add(new Tweekeuze(
				"Ja of Nee: Is er in Java verschil tussen een interface en een abstracte klasse?",
				new String[] { "Ja", "Nee" }, 0));
		vragen.add(new Tweekeuze(
				"Goed of Fout: Iedere klasse definitie in Java bevat een constructor.",
				new String[] { "Goed", "Fout" }, 1));

	}

}
