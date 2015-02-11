/*
 * Genereert een pseudorandom woord uit een tekstfile
 */

package oo15opg02galgje;

import java.util.Scanner;
import java.util.Random;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Leest woorden uit file en kan een pseudo random woord hiervan leveren
 * OO opgave 2
 * @author Pieter Koopman
 */
public class WoordLezer {
    private List<String> woorden = new ArrayList<String> (); // de woorden
    private int aantalWoorden = 0;                           // aantal gelezen woorden
    Random rand;                                             // om woord te kiezen
    
    /**
     * Constructor, telt het aantal woorden in de file.
     * Gelezen woorden worden opgeslagen in een arrayList.
     * IOexceptions bij het lezen worden gevangen en afgedrukt.
     * @param fileNaam: fileNaam van de file met woorden
     */
    public WoordLezer( String fileNaam ) {
        rand = new Random ();
        try {
            FileReader file = new FileReader( fileNaam );
            Scanner scan = new Scanner( file );
            for ( ; scan.hasNext("\\S+"); aantalWoorden += 1)
                woorden.add( scan.next("\\S+").toLowerCase() );
            file.close();
        } catch ( IOException ioe ) {
            System.out.println("Fout bij lezen van de file " + fileNaam + ": " + ioe.getMessage() );
        }
    }

    /**
     * @return het aantal gelezen woorden.
     */
    public int getAantalWoorden() {
        return aantalWoorden;
    }

    /**
     * Geeft een pseudo random woord uit de lijst met opgeslagen woorden
     * @return random woord uit gelezen lijst
     */
    public String geefWoord() {
        if ( aantalWoorden > 0 )
            return woorden.get( rand.nextInt( aantalWoorden ));
        else
            return "";
    }
}
