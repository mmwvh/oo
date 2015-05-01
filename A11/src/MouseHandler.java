import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MouseHandler extends JPanel implements MouseListener, MouseMotionListener {

	private GridFiller gf;
	private int x = 0;
	private int y = 0;

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
        
        System.out.println("lalla");
        
        Graphics graph = e.getComponent().getGraphics();
        System.out.println(graph);
        graph.setXORMode(Color.GREEN);
        graph.drawRect(x, y, x+nx, y+ny);
        repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		System.out.println("2");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		double newx = e.getX();
		double newy = e.getY();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}	
}
