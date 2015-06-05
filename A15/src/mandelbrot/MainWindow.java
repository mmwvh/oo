package mandelbrot;



import java.awt.Insets;

import javax.swing.JFrame;

/**
 * 
 * @author Sjaak Smetsers
 * @version 1.0, 14-03-2013
 */

/**
 * creates a window to which a GridView panel is added
 * 
 */
public class MainWindow  {
    
    public MainWindow ( GridView grid ) {
    	JFrame mainFrame = new JFrame ("Mandelbrot");
        
    	mainFrame.setLocationRelativeTo(null);
    	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	mainFrame.setResizable(false);
    	mainFrame.setVisible(true);
    	
        mainFrame.add(grid);
        mainFrame.pack();
    }
        
}
