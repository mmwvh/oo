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
public class RGBColors {
    
    private int [][] rgbColors;
    
    public static final int [] BLACK = new int [3]; 
    
    public RGBColors (int max_color_index) {
        rgbColors = new int [max_color_index][3];
        randomPalets ();
        randomColorSet ();

    }
    
    private static final int MAXRGB = 256;

    private static int [][][] palets = { 
        {{0,0},{1,-1},{0,1}},
        {{1,-1},{1,0},{0,0}},
        {{0,1},{0,1},{1,-1}},
        {{1,-1},{0,0},{1,0}},
        {{0,1},{0,1},{1,0}},
        {{1,0},{1,-1},{1,-1}},
        {{1,0},{0,1},{0,1}},
        {{1,-1},{1,0},{1,-1}}
    };
   
    private boolean randomBool () {
        return Math.random() < 0.5;
    } 
    
    void randomPalets () {
        for (int p = 0; p < palets.length; p++) {
            for (int c = 0; c < 3; c++) {
                int cw = randomBool () ? 1 : 0;
                int cd = randomBool () ? (cw * -1) : (1 - cw);
                palets [p][c][0] = cw;
                palets [p][c][1] = cd;
            }
        }
    } 
    
    private void randomColorSet () {
        int p_size = rgbColors.length / palets.length;
        for (int p = 0; p < palets.length; p++) {
            int [][] palet = palets [p];
            int r = palet [0][0] == 1 ? MAXRGB-1 : 0;
            int g = palet [1][0] == 1 ? MAXRGB-1 : 0;
            int b = palet [2][0] == 1 ? MAXRGB-1 : 0;
            
            int dr = palet [0][1] * MAXRGB / p_size;
            int dg = palet [1][1] * MAXRGB / p_size;
            int db = palet [2][1] * MAXRGB / p_size;
                    
            for (int i = 0 ; i < p_size ; i++) {
                rgbColors[i + p * p_size][0] = r;
                rgbColors[i + p * p_size][1] = g;
                rgbColors[i + p * p_size][2] = b;
                r += dr;
                g += dg;
                b += db;
            }
        }
    }
    
    public int [] getColor (int color_index) {
       return  rgbColors [color_index];
    }
    
    public int [] getColor2 (int color_index) {
       return  rgbColors [color_index];
    }
}
