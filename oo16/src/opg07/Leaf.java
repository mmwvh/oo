/**
 * 
 */
package opg07;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public enum Leaf implements QTNode {
	Black(false), White(true);
	private final boolean boolVal;

	private Leaf(boolean bval) {
		boolVal = bval;
	}

	public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
		bitmap.fillArea(x, y, width, boolVal);
	}

	public void writeNode(Writer out) {
		try {
			if (boolVal)
				out.write("01");
			else
				out.write("00");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}