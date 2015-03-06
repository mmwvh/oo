
public class View {
	
	public View() {
		
	}
	
	public void stelVraag(Vraag v) {
		System.out.print(v);
	}

	public void fout() {
		System.out.println("Sorry dit is niet goed, probeer het later nog eens.\n");
	}

	public void correct() {
		System.out.println("Dit is correct!\n");
	}

	public void gefeliciteerd() {
		System.out.println("Wow, jij bent een echte bolleboos!");
	
	}
}
