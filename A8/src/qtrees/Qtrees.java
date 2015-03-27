package qtrees;

import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;

/**
 *
 * @author Franka Buytenhuijs, Wesley van Hoorn s4356845, s4018044
 * @author Sjaak
 */
public class Qtrees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String test_tekst = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(test_tekst);
        QTree qt = new QTree( input );
        Bitmap bitmap = new Bitmap(8, 8);
        Writer writer = new OutputStreamWriter(System.out);
        qt.fillBitmap( bitmap );
        
        System.out.println("Van input naar bitmap: ");
        System.out.println(bitmap);
        
        System.out.println("Van boom naar string: ");
        qt.writeQTree(writer);
        
        QTree.bitmap2QTree(0, 0, 8, bitmap);
        
        System.out.println("\n\nVan bitmap naar boom en weer terug: ");
        qt.fillBitmap(bitmap);
        System.out.println(bitmap);
    }

}
