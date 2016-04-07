/**
 * 
 */
package opg07;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class QTree {
	QTNode root;

	public QTree(Reader input) {
		root = readQTree(input);
	}

	public QTree(Bitmap bitmap) {
		root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
	}

	public void fillBitmap(Bitmap bitmap) {
		root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
	}

	public void writeQTree(Writer sb) {
		root.writeNode(sb);
	}

	/**
	 * Reads the children for greyNode in readQTree
	 * 
	 * @param input
	 * @return size 4 array of children
	 */
	static private QTNode[] greyBuilder(Reader input) {
		QTNode[] children = new QTNode[4];
		for (int i = 0; i < children.length; i++) {
			children[i] = readQTree(input);
		}
		return children;
	}

	/**
	 * Builds the children for greyNode in bitmap2QTree
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @param width
	 *            of the partial bitmap
	 * @param bitmap
	 *            object
	 * @return size 4 array of children
	 */
	static private QTNode[] greyBuilder(int x, int y, int width, Bitmap bitmap) {
		QTNode[] children = new QTNode[4];

		int childWidth = width / 2;
		children[0] = bitmap2QTree(x, y, childWidth, bitmap);
		children[1] = bitmap2QTree(x + childWidth, y, childWidth, bitmap);
		children[2] = bitmap2QTree(x + childWidth, y + childWidth, childWidth, bitmap);
		children[3] = bitmap2QTree(x, y + childWidth, childWidth, bitmap);

		return children;
	}

	/**
	 * Counts the occurrence of black leafs
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @param width
	 *            of the partial bitmap
	 * @param bitmap
	 *            object
	 * @return black leaf count
	 */
	private static int bitmapReader(int x, int y, int width, Bitmap bitmap) {
		int bit = 0;

		for (int j = y; j < width; j++) {
			for (int i = x; i < width; i++) {
				if (!bitmap.getBit(i, j)) {
					bit = bit + 1;
				}
			}
		}
		return bit;
	}

	/**
	 * Reads a QTree from a string
	 * 
	 * @param input
	 * @return corresponding vertex
	 */
	private static QTNode readQTree(Reader input) {
		try {
			int firstBit = input.read() - 48; // ASCII 0 == 48
			int secondBit = 0;

			if (firstBit == 0) {
				secondBit = input.read() - 48; // ASCII 0 == 48
				if (secondBit == 0)
					return Leaf.Black;
				return Leaf.White;
			}
			return new GreyNode(greyBuilder(input));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Builds a QTree from a bitmap
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @param width
	 *            of the partial bitmap
	 * @param bitmap
	 *            object
	 * @return corresponding vertex
	 */
	public static QTNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {

		int bit = bitmapReader(x, y, width, bitmap);

		if (bit == 0)
			return Leaf.White;
		else if (bit == width * width)
			return Leaf.Black;
		else
			return new GreyNode(greyBuilder(x, y, width, bitmap));
	}

}
