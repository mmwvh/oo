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
	}

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
						
			for(int i =0; i<4; i++){
				readQTree(input);
			}
			return new GreyNode();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static QTNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
		return null;
	}

}
