/**
 * 
 */
package qtrees;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Franka Buytenhuijs, Wesley van Hoorn s4356845, s4018044
 *
 */
public class BlackLeaf extends QTNode {

	@Override
	public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
		fillArea(x, y, width, bitmap, false);
	}

	@Override
	public void writeNode(Writer out) {
		try {
			out.write("00");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
