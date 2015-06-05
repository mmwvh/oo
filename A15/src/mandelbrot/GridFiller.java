/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Sjaak
 */
public class GridFiller extends SwingWorker<Object, List<ColorPoint>> {

	private Area area;
	private Grid grid;
	public static final int MAX_ITERATIONS = 400;
	private static final RGBColors rgbColors = new RGBColors(MAX_ITERATIONS);
	private static final ColorChooser colorChooser = new ColorChooser();
	private int progress;
	private JProgressBar pb;

	public GridFiller(Grid grid, Area area, JProgressBar pb) {
		progress = 0;
		this.pb = pb;
		pb.setValue(progress);
		
		this.grid = grid;
		this.area = area;
	}

	public Area getArea() {
		return area;
	}

	public List<ColorPoint> fill() {

		int grid_w = grid.getWidth(), grid_h = grid.getHeight();
		double area_w = area.getWidth(), area_h = area.getHeight();
		double dx = area_w / grid_w, dy = area_h / grid_h;

		List<ColorPoint> cpl = new ArrayList<ColorPoint>();

		double x = area.getX();
		for (int i = 0; i < grid_w; i++) {
			double y = area.getY();
			for (int j = 0; j < grid_h; j++) {
				int color = colorChooser.getColorIndex(x, y);
				int[] rgb = color == -1 ? RGBColors.BLACK : rgbColors
						.getColor(color);

				cpl.add(new ColorPoint(i, j, rgb));

				y -= dy;
			}
			x += dx;
		}
		return cpl;
	}

	@Override
	protected void process(List<List<ColorPoint>> publishedVals) {

		for (int l = 0; l < publishedVals.size(); l++) {
			for (int c = 0; c < publishedVals.get(l).size(); c++) {
				grid.setPixel(publishedVals.get(l).get(c).getX(), publishedVals
						.get(l).get(c).getY(), publishedVals.get(l).get(c)
						.getColor());
			}
		}
		progress += MAX_ITERATIONS / 20;
		pb.setValue(progress);
	}
	
	@Override
	protected Object doInBackground() throws Exception {
		int stepSize = 20;
		
		for (int c = 1; c < MAX_ITERATIONS; c += stepSize) {
			colorChooser.setMaxIndex(c);
			publish(fill());			
		}

		return null;
	}
	
	public JProgressBar getPB() {
		return pb;
	}
}
