
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franka Buytenhuijs, Wesley van Hoorn s4356845, s4018044
 * @author Sjaak Smetsers
 */
public class Winkel {

	private List<Gebruiker> leden;
	private List<Artikel> producten;
	private File artFile;
	private File gebFile;

	private final static String art_file_name = "WinkelArtikelen.data";
	private final static String geb_file_name = "WinkelLeden.data";

	public Winkel() {
		artFile = new File(art_file_name);
		gebFile = new File(geb_file_name);
		
		if (artFile.exists()) {
			try {
				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream(artFile));
				producten = (List<Artikel>) in.readObject();
				in.close();
			} catch (IOException iOException) {
				System.out.println(iOException);
				System.exit(1);
			} catch (ClassNotFoundException classNotFoundException) {
				System.out.println(classNotFoundException);
				System.exit(1);
			}
		} else {
			producten = new ArrayList<Artikel>();
		}
		
		if (gebFile.exists()) {
			try {
				ObjectInputStream in = new ObjectInputStream(
						new FileInputStream(gebFile));
				leden = (List<Gebruiker>) in.readObject();
				in.close();
			} catch (IOException iOException) {
				System.out.println(iOException);
				System.exit(1);
			} catch (ClassNotFoundException classNotFoundException) {
				System.out.println(classNotFoundException);
				System.exit(1);
			}
		} else {
			leden = new ArrayList<Gebruiker>();
		}
	}

	/**
	 * Sluiten van de stream
	 */
	public void sluit() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(artFile));
			out.writeObject(producten);
			out.close();
		} catch (IOException iOException) {
			System.out.println(iOException);
			System.exit(1);
		}
	}
	
	/**
	 * Sluiten van de gebruiker stream
	 */
	public void sluitgeb() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(gebFile));
			out.writeObject(leden);
			out.close();
		} catch (IOException iOException) {
			System.out.println(iOException);
			//System.exit(1);
		}
	}

	/**
	 * 
	 * @param g gebruiker die aan de lijst wordt toegevoegd
	 */
	public void nieuwGebruiker(Gebruiker g) {
		if (!leden.contains(g)) {
			System.out.println("Welkom " + g.getUserID());
			leden.add(g);
		}
		else {
			System.out.println("Welkom terug!");
		}
	}

	/**
	 * 
	 * @param art artikel dat aan de lijst wordt toegevoegd
	 */
	public void nieuwArtikel(Artikel art) {
		producten.add(art);
	}

	/**
	 * toont de lijst producten
	 */
	public void toon() {
		if (producten.size() == 0) {
			System.out.println("Helaas zijn er nog geen producten te koop aangeboden. U kunt wel producten verkopen.");
		} else {
			for (int i = 0; i < producten.size(); i++) {
				System.out.println(i + 1 + " " + producten.get(i));
			}

		}
	}

	/**
	 * 
	 * @param a artikel dat gekocht is en niet meer in de verkoop lijst hoort te staan
	 */
	public void remove(Artikel a) {
		producten.remove(a);
	}

	public Artikel getArtikel(int i) {
		return producten.get(i);
	}
}
