/**
 * 
 */
package opg07;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author Sjaak Smetsers
 * @version 11-03-2016
 */
public interface QTNode {
	/**
	 * Fills the area of the bitmap with leafs accourdingly
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @param width
	 *            of the partial bitmap
	 * @param bitmap
	 *            object
	 */
	public void fillBitmap(int x, int y, int width, Bitmap bitmap);

	/**
	 * Writes the tree as a single bit string
	 * 
	 * @param out
	 */
	public void writeNode(Writer out);
}
