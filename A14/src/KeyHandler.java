import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Keyboard handler of views for controller. Pressing keys changes the
 * controller.
 * 
 * @author pieterkoopman
 */
public class KeyHandler extends KeyAdapter {

	private Controller controller;

	public KeyHandler(Controller c) {
		controller = c;
	}

/**
     * on key down 'q' stop program
     * on key down 's' stop the cars
     * on key down ' ' all cars one step
     * on key down '<' decrease delay
     * on key down '>' increase delay
     * on any other key activate the cars
     * @param e the key event
     */
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'q':
			System.exit(0);
		case 's':
			controller.stopCars();
			break;
		case ' ':
			controller.stepAllCars();
			break;
		case '<':
			controller.setDelay(controller.getDelay() - 50);
			break;
		case '>':
			controller.setDelay(controller.getDelay() + 50);
			break;
		default:
			controller.resumeCars();
		}
	}
}
