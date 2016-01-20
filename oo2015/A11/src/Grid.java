/**
 *
 * @author Sjaak Smetsers
 * @version 1.0, 13-03-2013
 */

/**
 * An interface providing a context for drawing
 * pictures pixel-wise
 */
public interface Grid {
    /**
     * setPixel puts a pixel on the specified location
     * @param x, y coordinates of the location
     * @param rgb the color specified as an rgb value
     */
    void setPixel (int x, int y, int [] rgb);
    
    /**
     * @return the width of the grid
     */
    int getWidth  ();
    /**
     * @return the height of the grid
     */
    int getHeight ();
    
}
