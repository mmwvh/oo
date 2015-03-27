package qtrees;

import java.io.Writer;

/**
 *
 * @author Sjaak Smetsers
 * @version 18-03-2014
 */
public abstract class QTNode {
	/**
	 * Fills a bitmap corresponding to the nodes of the tree
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @param width
	 * @param bitmap
	 *            current bitmap
	 */
	public abstract void fillBitmap(int x, int y, int width, Bitmap bitmap);

	/**
	 * Fills a string corresponding to the nodes of the tree
	 * 
	 * @param out
	 *            output of a node
	 */
	public abstract void writeNode(Writer out);

	/**
	 * Fills the area of a bitmap
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @param width
	 * @param bitmap
	 *            current bitmap
	 * @param val
	 *            boolean value corresponding to the leafnodes of the tree
	 */
	public static void fillArea(int x, int y, int width, Bitmap bitmap,
			boolean val) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				bitmap.setBit(x + i, y + j, val);
			}
		}
	}
}
