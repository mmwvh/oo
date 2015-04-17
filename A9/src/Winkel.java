

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
 * @author Sjaak Smetsers
 */
public class Winkel {
	
	private List<Gebruiker> leden;
    private List<Artikel> producten;
    private File artFile;

    private final static String art_file_name = "WinkelArtikelen.data";

    public Winkel() {
        artFile = new File(art_file_name);
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
    }

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

    public void nieuwArtikel(Artikel art) {
        producten.add(art);
    }

    public void toon() {
        for (Artikel art : producten) {
            System.out.println(art);
        }
    }
    
    /**
	 * 
	 * @param a
	 */
	public void remove(Artikel a) {
		producten.remove(a);
	}
}
