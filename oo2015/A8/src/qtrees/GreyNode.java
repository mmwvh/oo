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
public class GreyNode extends QTNode {

	private final QTNode[] children = new QTNode[4];

	/**
	 * fillBitmap over all children of GreyNode
	 * _____
	 * |1|2|
	 * |4|3|
	 */
	@Override
	public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
		children[0].fillBitmap(x, y, width / 2, bitmap);
		children[1].fillBitmap(x + (width / 2), y, width / 2, bitmap);
		children[2].fillBitmap(x + (width / 2), y + (width / 2), width / 2,
				bitmap);
		children[3].fillBitmap(x, y + (width / 2), width / 2, bitmap);
	}

	/**
	 * writeNode over all children of GreyNode
	 */
	@Override
	public void writeNode(Writer out) {
		try {
			out.write("1");
			for (int i = 0; i < children.length; i++) {
				children[i].writeNode(out);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setChildren(QTNode child, int i) {
		this.children[i] = child;
	}
}
