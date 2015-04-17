

/**
 *
 * @author Sjaak
 */
public class WinkelTest {

    public static void main(String[] args) {
        Winkel w = new Winkel();

        w.toon();

        w.nieuwArtikel(new Artikel("CD: Frans Bauer, \"Voor elke dag\"", 8.99, NIET_BOEKEN ));
        w.sluit();
    }

}
