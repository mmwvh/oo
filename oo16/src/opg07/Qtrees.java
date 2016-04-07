/**
 * 
 */
package opg07;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class Qtrees {

	public static void main(String[] args) {
		String test_tekst = "10011010001010010001010101100011000101000000";
		StringReader input = new StringReader(test_tekst);

		QTree qt = new QTree(input);
		Bitmap bitmap = new Bitmap(8, 8);
		StringWriter writer = new StringWriter();

		System.out.println("Input to bitmap: ");
		qt.fillBitmap(bitmap);
		System.out.println(bitmap);

		System.out.println("Tree to string: ");
		qt.writeQTree(writer);
		System.out.println(writer.toString());
		
		System.out.println("\nBitmap to tree and back again: ");
		QTree qt2 = new QTree(bitmap);
		
		qt2.fillBitmap(bitmap);
		System.out.println(bitmap);
	}

}
