package mandelbrot;

/**
 *
 * @author Sjaak Smetsers
 */
public class AreaController  {
    Area a;
    Grid grid;
    
    public AreaController ( Area a, Grid grid ) {
        this.a = a;
        this.grid = grid;
    }
    
    public void setArea(AreaSelector selector, int x, int y, int w, int h ) {
        a = a.zoom(x, y, w, h, grid.getWidth(), grid.getHeight());
        //filler = new GridFiller (grid, area, filler.getPB(), x, y, w, h);
        //filler.execute();
    }

    public void fillArea() {
		Area area = new Area(-2.5, 2.5, 5, 5);
		Area area2 = new Area (0, 2.5, 5, 5);
		Area area3 = new Area (-2.5, 0, 5, 5);
		Area area4 = new Area (0, 0, 5, 5);
		
/*		GridFiller filler = new GridFiller(grid, area, grid.getPB(),
				0, 0,
				GridView.GRID_WIDTH/2, GridView.GRID_HEIGHT/2);
		GridFiller filler2 = new GridFiller(grid, area2, grid.getPB(),
				GridView.GRID_WIDTH/2, 0,
				GridView.GRID_WIDTH, GridView.GRID_HEIGHT/2);
		GridFiller filler3 = new GridFiller(grid, area3, grid.getPB(),
				0, grid.GRID_HEIGHT/2,
				grid.GRID_WIDTH/2, grid.GRID_HEIGHT);
		GridFiller filler4 = new GridFiller(grid, area4, grid.getPB(),
				grid.GRID_WIDTH/2, grid.GRID_HEIGHT/2,
				grid.GRID_WIDTH, grid.GRID_HEIGHT);
  */  }
    
}
