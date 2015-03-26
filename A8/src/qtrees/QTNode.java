
package qtrees;

import java.io.Writer;

/**
 *
 * @author Sjaak Smetsers
 * @version 18-03-2014
 */
public abstract class QTNode {
    public abstract void fillBitmap( int x, int y, int width, Bitmap bitmap );
    public abstract void writeNode( Writer out );
    public abstract boolean sameLeaf( QTNode other_node );
    public abstract int countBlacks(int n);

    public static void fillArea( int x, int y, int width, Bitmap bitmap, boolean val ){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                bitmap.setBit(x+i, y+j, val);
            }
        }
    }
}
