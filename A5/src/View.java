public class View {

	public View() {

	}

	public void stelVraag(Vraag v) {
		System.out.print(v);
	}

	public void fout() {
		System.out
				.println("Sorry dit is niet goed, probeer het later nog eens.\n");
	}

	public void correct() {
		System.out.println("Dit is correct!\n");
	}

	/**
	 * Gepersonaliseerde felicitatie.
	 * 
	 * @param score
	 */
	public void gefeliciteerd(int score) {
		if (score < 0) {
			System.out.println("Faalhaas, je score is: " + score);
		} else {
			System.out
					.println("Wow, jij bent een echte bolleboos!\nJe score is: "
							+ score);
		}

	}
}
