package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

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
		try {
			sb.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Recursively generate a QTree from an input string
	 * 
	 * @param input
	 *            stringreader
	 * @return nodes corresponding to the input string: WhiteLeaf, BlackLeaf or
	 *         GreyNode
	 */
	private static QTNode readQTree(Reader input) {
		try {
			int r = input.read();
			int n = 0;
			if ((char) r == '0') { // ASCII 0 == 48
				n = input.read();
				if ((char) n == '0') { // Next read char
					return new BlackLeaf();
				}
				return new WhiteLeaf();
			}

			GreyNode grey = new GreyNode();
			for (int i = 0; i < 4; i++) {
				grey.setChildren(readQTree(input), i);
			}
			return grey;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Recursively generate a QTree from a bitmap
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinate
	 * @param width
	 * @param bitmap
	 *            current bitmap
	 * @return nodes corresponding to the bitmap: WhiteLeaf, BlackLeaf or
	 *         GreyNode
	 */
	public static QTNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
		int c = 0;
		for (int i = y; i < width; i++) {
			for (int j = x; j < width; j++) {
				if (!bitmap.getBit(j, i)) {
					c++;
				}
			}
		}
		if (c == 0) {
			return new WhiteLeaf();
		}
		if (c == (width * width)) {
			return new BlackLeaf();
		}
		GreyNode grey = new GreyNode();
		grey.setChildren(bitmap2QTree(x, y, width / 2, bitmap), 0);
		grey.setChildren(bitmap2QTree(x + (width / 2), y, width / 2, bitmap), 1);
		grey.setChildren(
				bitmap2QTree(x + (width / 2), y + (width / 2), width / 2,
						bitmap), 2);
		grey.setChildren(bitmap2QTree(x, y + (width / 2), width / 2, bitmap), 3);

		return grey;
	}

}
