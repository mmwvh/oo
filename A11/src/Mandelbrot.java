/**
 * An example of the use of our pixel drawing framework
 * @author Sjaak Smetsers
 * @version 1.0, 14-03-2013
 */
public class Mandelbrot 
{
    public static void main(String args[]) {    	       
      
    	
    	MainWindow fractal_win = new MainWindow();
        GridFiller filler = new GridFiller (fractal_win.getGrid());
        fractal_win.setFiller(filler);
        ScaleWindow scale_win = new ScaleWindow(filler);
        filler.setScaleWindow(scale_win);
        filler.fill();
    }

}