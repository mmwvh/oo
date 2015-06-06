package mandelbrot;

/**
*
* @author Sjaak
* @author Franka Buytenhuijs / s4356845
* @author Wesley van Hoorn / s4018044
*/
public class AreaController  {
    Area a;
    GridView grid;
    
    public AreaController ( Area a, GridView grid ) {
        this.a = a;
        this.grid = grid;
    }
    
    public void setArea(AreaSelector selector, int x, int y, int w, int h ) {
        a = a.zoom(x, y, w, h, grid.getWidth(), grid.getHeight());
        fillArea();
    }

    public void fillArea() {
    	
		Area area = new Area(a.getX(), a.getX(),a.getWidth(), a.getHeight());
		Area area2 = new Area (a.getX()+(a.getWidth()/2), a.getX(), a.getWidth(), a.getHeight());
		Area area3 = new Area (a.getX(), (a.getY()-a.getHeight()/2), a.getWidth(), a.getHeight());
		Area area4 = new Area (a.getX()+(a.getWidth()/2), (a.getY()-a.getHeight()/2), a.getWidth(), a.getHeight());
		
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
		
		filler.execute();
		filler2.execute();
		filler3.execute();
		filler4.execute();
    }
    
}
