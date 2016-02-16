package opg03;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Leest woorden uit gegeven file en levert pseudo random woorden uit lijst OO
 * 2016 opgave 3
 * 
 * @author Pieter Koopman en updates door Wesley van Hoorn, 4018044
 */
public class WoordLezer {
	private final List<String> woorden; // de woorden
	private final Random rand;

	/**
	 * Constructor, telt het aantal woorden in de file. Gelezen woorden worden
	 * opgeslagen in een arrayList. IOexceptions bij het lezen worden gevangen
	 * en afgedrukt.
	 * 
	 * @param fileNaam:
	 *            fileNaam van de file met woorden
	 */
	public WoordLezer(String fileNaam) {
		rand = new Random();
		woorden = new ArrayList<String>();
		try {
			FileReader fileReader = new FileReader(fileNaam);
			Scanner file = new Scanner(fileReader);
			while (file.hasNext("\\S+")) {
				woorden.add(file.next("\\S+").toLowerCase());
			}
			fileReader.close();
			file.close();
		} catch (IOException ioe) {
			System.out.println("Fout bij lezen van de file " + fileNaam + ": " + ioe.getMessage());
		}
	}

	/**
	 * @return het aantal gelezen woorden.
	 */
	public int getAantalWoorden() {
		return woorden.size();
	}

	/**
	 * Geeft een pseudo random woord uit de lijst met opgeslagen woorden, of het
	 * lege woord als de lijst leeg is.
	 * 
	 * @return gekozen woord
	 */
	public String geefWoord() {
		if (!woorden.isEmpty())
			return woorden.get(rand.nextInt(getAantalWoorden()));
		else
			return "";
	}
}
