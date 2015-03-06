import java.util.List;

/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Quiz {

	private List<Vraag> spel;
	private String antwoord;
	private int score = 0;
	Controller controller = new Controller();
	View view = new View();

	public Quiz(List<Vraag> spel) {
		this.spel = spel;
	}

	/**
	 * Speelt net zolang totdat alle vragen correct zijn beantwoord.
	 */
	public void run() {
		while (!spel.isEmpty()) {
			Vraag v = spel.get(0);
			view.stelVraag(v);
			controller.setInvoer();
			antwoord = controller.getAntwoord();
			update(v);
		}
		view.gefeliciteerd(score);
	}

	/**
	 * Update de lijst met vragen. Indien een vraag fout wordt beantwoord wordt
	 * deze vraag aan het einde van de lijst geplaatst.
	 * 
	 * @param v
	 */
	private void update(Vraag v) {
		spel.remove(0);
		if (!v.isCorrect(antwoord)) {
			score -= 1;
			view.fout();
			spel.add(v);
		} else {
			score += 2;
			view.correct();
		}
	}
}
