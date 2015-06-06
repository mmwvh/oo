package mandelbrot;

/**
 *
 * @author Sjaak
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 */
public class Area {
    private final double startX, startY, width, height;
    
    public Area (double x_tl, double y_tl, double width, double height) {
        startX = x_tl; startY = y_tl; this.width = width; this.height = height;
    }
    
    public double getX ()       { return startX; }
    public double getY ()       { return startY; }
    public double getWidth ()   { return width; }
    public double getHeight ()  { return height; }
    
    public Area zoom (int xul, int yul, int zw, int zh, int tw, int th) {
        double zoom_fact = ((double) zw) / tw;
        return new Area (startX + (width  * xul) / tw,
                         startY - (height * yul) / th,
                         width * zoom_fact,
                         height * zoom_fact);
    }
    
}
