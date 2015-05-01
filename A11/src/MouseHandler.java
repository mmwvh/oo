import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MouseHandler extends JPanel implements MouseListener,
		MouseMotionListener {

	private GridFiller gf;
	private int x = 0;
	private int y = 0;
	private Rectangle field;

	public MouseHandler(GridFiller gf) {
		this.gf = gf;
	}

	public void mouseClicked(MouseEvent e) {
		double newx = e.getX();
		double newy = e.getY();
		if (e.isShiftDown()) {
			gf.mousePressed(newx, newy, false);
		} else {
			gf.mousePressed(newx, newy, true);
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {

		int nx = e.getX();
		int ny = e.getY();
		Graphics graph = e.getComponent().getGraphics();
		graph.clearRect(x, y, nx - x, ny - y);
		// graph.setXORMode(Color.GREEN);
		graph.drawRect(x, y, nx - x, ny - y);
		repaint();
		graph.drawRect(x, y, nx - x, ny - y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		double newx = e.getX();
		double newy = e.getY();
		gf.mousePressed((x + newx) / 2, (y + newy) / 2, true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
