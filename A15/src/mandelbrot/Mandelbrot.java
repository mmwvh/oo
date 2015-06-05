/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

import java.beans.PropertyChangeEvent;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

/*
 This class creates an applet for generating Mandelbrot sets. The applet is
 meant to be embedded in an HTML page and has hooks to interact with the page.
 Functions are provided to allow the user to zoom in and out and to move around
 on the surface of the figure. The user can also select from a set of color
 schemes.
 */

public class Mandelbrot {
	public static void main(String args[]) {
	
		GridView grid = new GridView();
		MainWindow mandel = new MainWindow(grid);
		

		Area a = new Area(-2.5, 2.5, 5, 5);
		
		Area area = new Area(a.getX(), a.getY(), a.getWidth(), a.getHeight());
		Area area2 = new Area (a.getX() + (a.getWidth()/2), a.getY(), a.getWidth(), a.getHeight());
		Area area3 = new Area (a.getX(), a.getY() - (a.getHeight()/2), a.getWidth(), a.getHeight());
		Area area4 = new Area (a.getX() + (a.getWidth()/2), a.getY() - (a.getHeight()/2), a.getWidth(), a.getHeight());
		
		GridFiller filler = new GridFiller(grid, area, grid.getPB(),
				0, 0,
				GridView.GRID_WIDTH/2, GridView.GRID_HEIGHT/2);
		GridFiller filler2 = new GridFiller(grid, area2, grid.getPB(),
				GridView.GRID_WIDTH/2, 0,
				GridView.GRID_WIDTH, GridView.GRID_HEIGHT/2);
		GridFiller filler3 = new GridFiller(grid, area3, grid.getPB(),
				0, GridView.GRID_HEIGHT/2,
				GridView.GRID_WIDTH/2, GridView.GRID_HEIGHT);
		GridFiller filler4 = new GridFiller(grid, area4, grid.getPB(),
				GridView.GRID_WIDTH/2, GridView.GRID_HEIGHT/2,
				GridView.GRID_WIDTH, GridView.GRID_HEIGHT);
		
		AreaController controller = new AreaController(a, grid);
		AreaSelector selector = new AreaSelector(grid, controller);

		filler.execute();
		filler2.execute();
		filler3.execute();
		filler4.execute();
	}

}