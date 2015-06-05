/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

/**
 *
 * @author Sjaak
 */
public interface Grid {
    void setPixel (int x, int y, int [] rgb);
    
    int getWidth  ();
    int getHeight ();   
}
