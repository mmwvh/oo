import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseHandler extends MouseAdapter implements MouseListener {

	private GridFiller gf;
	public MouseHandler(GridFiller gf){
		this.gf = gf;
	}
	
	public void MouseDragged(MouseEvent e){
		
	}
	
	public void mouseClicked(MouseEvent e){
		double newx = e.getX();
		double newy = e.getY();
		gf.mousePressed(newx, newy);
		
		
	}

}
