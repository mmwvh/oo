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
public class GreyNode implements QTNode {

	private final QTNode[] children;

	public GreyNode(QTNode[] children) {
		this.children = children;
	}

	public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
		assert children.length == 4 : "GreyNode array overflow.";

		int childWidth = width / 2;
		children[0].fillBitmap(x, y, childWidth, bitmap);
		children[1].fillBitmap(x + childWidth, y, childWidth, bitmap);
		children[2].fillBitmap(x + childWidth, y + childWidth, childWidth, bitmap);
		children[3].fillBitmap(x, y + childWidth, childWidth, bitmap);
	}

	public void writeNode(Writer out) {
		try {
			out.write("1");
			for (int i = 0; i < children.length; i++) {
				children[i].writeNode(out);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
