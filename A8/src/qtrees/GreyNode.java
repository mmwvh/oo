/**
 * 
 */
package qtrees;

import java.io.Writer;

/**
 * @author mmwvh
 *
 */
public class GreyNode extends QTNode{
	
	private final QTNode[] children = new QTNode[4];

	@Override
	public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeNode(Writer out) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean sameLeaf(QTNode other_node) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int countBlacks(int n) {
		int blacks = 0;
		for(QTNode node: children) {
			blacks += node.countBlacks(n/2);
		}
		return blacks;
	}

}
