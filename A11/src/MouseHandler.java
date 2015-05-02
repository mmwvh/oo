/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 */
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
	private boolean drag = false;

	public MouseHandler(GridFiller gf) {
		this.gf = gf;
	}

	/**
	 * ActionListener on mouse click to get coordinates
	 */
	public void mouseClicked(MouseEvent e) {
		double newx = e.getX();
		double newy = e.getY();
		if (e.isShiftDown()) {
			gf.mousePressed(newx, newy, false);
		} else {
			gf.mousePressed(newx, newy, true);
		}

	}

	/**
	 * ActionListener on mouse dragged to draw rectangles
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		drag = true;
		int nx = e.getX();
		int ny = e.getY();
		int xpoint = Math.min(x, nx);
		int ypoint = Math.min(y, ny);
		int width = Math.max(x - nx, nx - x);
		int height = Math.max(y - ny, ny - y);
		Graphics graph = e.getComponent().getGraphics();

		graph.drawRect(xpoint, ypoint, width, height);
		graph.clearRect(xpoint, ypoint, width, height);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	/**
	 * ActionListener on mouse pressed to get coordinates
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	/**
	 * ActionListener on mouse release to set new scale
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		double newx = e.getX();
		double newy = e.getY();
		if (drag) {
			gf.mousePressed((x + newx) / 2, (y + newy) / 2, true);
		}
		drag = false;

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
