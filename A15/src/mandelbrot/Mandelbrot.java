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

//		JFrame window = new JFrame();
//		JProgressBar progressBar = new JProgressBar(0, 100);
//		progressBar.setValue(0);
//		progressBar.setStringPainted(true);
//		window.setSize(width, height);
//		window.add(progressBar);
//		window.setVisible(true);

		Area area = new Area(-2.5, 2.5, 5, 5);
		GridFiller filler = new GridFiller(grid, area, grid.getPB());
		AreaController controller = new AreaController(filler, grid);
		AreaSelector selector = new AreaSelector(grid, controller);
		filler.execute();
	}

}