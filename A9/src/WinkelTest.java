

/**
 *
 * @author Sjaak
 */
public class WinkelTest {

    public static void main(String[] args) {
        Winkel w = new Winkel();
        Controller c = new Controller();
        //w.toon();
        w.nieuwArtikel(new Artikel("CD: Frans Bauer, \"Voor elke dag\"", 8.99, Categorie.NIET_BOEKEN ));
        //w.toon();
        w.sluit();
    }

}
