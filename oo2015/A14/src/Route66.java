/**
 * OO1route66 initial class
 * 
 * @author Pieter Koopman Route66 class constructs model, view and controller
 */
public class Route66 {
	Controller controller;

	/**
	 * the main method for OO13route66
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Route66 r66 = new Route66();
	}

	/**
	 * the main constructor: - creates model, controller and views
	 */
	public Route66() {
		Model model = new Model();		

		RoadView rview = new RoadView(model);
		TableView tview = new TableView(model);
		model.addView(tview);
		model.addView(rview);
		model.ExecutiveProducer();

		controller = new Controller(model);

		KeyHandler keyHandler = new KeyHandler(controller);
		rview.addKeyListener(keyHandler);
		tview.addKeyListener(keyHandler);

		tview.setVisible(true);
		rview.setVisible(true);

		//controller.run();
	}
}
