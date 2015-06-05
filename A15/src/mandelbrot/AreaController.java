package mandelbrot;

/**
 *
 * @author Sjaak Smetsers
 */
public class AreaController  {
    GridFiller filler; 
    Grid grid;
    
    public AreaController ( GridFiller filler, Grid grid ) {
        this.filler = filler;
        this.grid = grid;
    }
    
    public void setArea(AreaSelector selector, int x, int y, int w, int h ) {
        Area area = filler.getArea().zoom(x, y, w, h, grid.getWidth(), grid.getHeight());
        filler = new GridFiller (grid, area, filler.getPB());
        filler.execute();
    }

}
