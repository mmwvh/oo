import java.util.Scanner;

public class Controller {

	private Scanner scanner;
	private String antwoord;

	public Controller() {
		this.scanner = new Scanner(System.in);
	}

	public void setInvoer() {
		this.antwoord = scanner.nextLine();
	}

	public String getAntwoord() {
		return antwoord;
	}
}
