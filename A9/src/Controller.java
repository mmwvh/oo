import java.util.Scanner;

public class Controller {
	View view = new View();
	Winkel w = new Winkel();
	
	public Controller() {
		login();
	}

	public void login() {
		int s;
		Scanner in = new Scanner(System.in);
		view.display("Welkom in de winkel: Geef uw studentnummer in zonder s");
		s = in.nextInt();
		Gebruiker geb = new Gebruiker(s); 	
		watDoen();
	}

	public void watDoen(){
		int s;
		view.display("Wat wilt u doen? \nToets 1 voor kopen\nToets 2 voor verkopen");
		Scanner in = new Scanner(System.in);
		s = in.nextInt();
		if(s == 1){
			koop();
		}
		else if(s==2){
			verkoop();
		}
		else{
			view.display("Deze invoer is incorrect, probeer het opnieuw");
			watDoen();
		}
	}
	public void koop() {
		view.display("U heeft gekozen voor een Artikel kopen dit is het aanbod:\n");
		w.toon();
		view.display("Toets het artikel nummer in van het artikel dat u wilt kopen, wilt u toch niets kopen toets dan -1:\n");
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		if(s == -1){
			view.display("Bedankt voor uw bezoek, en tot ziens");
			w.sluit();
		}
		else{
			Artikel gekocht = w.getArtikel(s-1);
			w.remove(gekocht);
			String g = gekocht.toString();
			view.display("U heeft: ");
			System.out.print(gekocht.toString());
			view.display(" gekozen, u kan nu betalen");
			nogEenKeer();
		}
	}

	public void verkoop() {
		Categorie c = null;
		view.display("U heeft gekozen voor een artikel verkopen");
		view.display("Wat is de naam van uw artikel?");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		view.display("Wat is prijs van uw artikel in euro's?");
		Scanner in2 = new Scanner(System.in);
		int i = in2.nextInt();
		view.display("Is uw artikel een boek? Toets 1 voor ja en 2 voor nee");
		Scanner in3 = new Scanner(System.in);
		int cat = in3.nextInt();
		if(cat == 1){
			c = Categorie.BOEKEN;
		}
		else if(cat == 2){
			c = Categorie.NIET_BOEKEN;
		}
		else{
			view.display("De invoer is incorrect probeer het opnieuw.");
			verkoop();
		}
		Artikel a = new Artikel(s,i,c);
		view.display("U heeft het volgende artikel toegevoegd aan de winkel");
		System.out.println(a.toString());
		w.nieuwArtikel(a);
		nogEenKeer();
	}
	
	public void nogEenKeer(){
		view.display("Wilt u nog een producten kopen/verkopen? Toets 1, zo niet toets dan 2");
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		if(s == 1){
			watDoen();
		}
		else if(s==2){
			w.sluit();
		}
		else{
			view.display("Deze invoer is onjuist, probeer het opnieuw");
			nogEenKeer();
		}
	}

}