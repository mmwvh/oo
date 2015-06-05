/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Sjaak
 */
public class AreaSelector extends MouseInputAdapter {

    private Component component;
    private AreaController controller;
    private Stopper toBeStopped ;

    public AreaSelector(Component component, AreaController controller) {
        this.component = component;
        this.controller = controller;
        component.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if ( toBeStopped != null ){
            toBeStopped.tryToStop();
        }
        int w = component.getWidth() / 2;
        int h = component.getHeight() / 2;
        controller.setArea(this, e.getX() - w / 2,  e.getY() - h / 2, w, h);
    }

    public void setStopper( Stopper stopper ) {
        this.toBeStopped = stopper;        
    }
    
}
