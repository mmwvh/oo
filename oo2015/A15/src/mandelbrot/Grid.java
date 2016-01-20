/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

/**
*
* @author Sjaak
* @author Franka Buytenhuijs / s4356845
* @author Wesley van Hoorn / s4018044
*/
public interface Grid {
    void setPixel (int x, int y, int [] rgb);
    
    int getWidth  ();
    int getHeight ();   
}
