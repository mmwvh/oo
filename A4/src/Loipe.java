/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Loipe implements InfoLoipe {
	private int x = 0, y = 0, xmin = 0, xmax = 0, ymin = 0, ymax = 0;
	private String pad;
	private Direction huidig = Direction.N;
	private Fragment[][] loipe;
	private Punt[] puntArray;
	
	public Loipe(String pad) {
		this.pad = pad;
		puntArray = new Punt[pad.length()];
		loipeSize();
		loipe = new Fragment[Math.abs(xmin - xmax) + 1][Math.abs(ymin - ymax) + 1];
		loipeFill();
	}

	/**
	 * bepaald de lengte en breedte van hte parcours
	 */
	private void loipeSize() {

		for (int i = 0; i < (pad.length()); i++) {
			char nextStep = pad.charAt(i);

			if (nextStep == 'r') {
				huidig = huidig.turnRight();
			} else if (nextStep == 'l') {
				huidig = huidig.turnLeft();
			}
			move(huidig);
			xMax();
			xMin();
			yMax();
			yMin();
		}
	}

	/**
	 * vult de 2 dimeonsionale array met de juiste fragmenten op de juiste plaats
	 */
	private void loipeFill() {
		x = Math.abs(xmin);
		y = Math.abs(ymin - 1);
		huidig = Direction.N;
		Fragment frag = Fragment.NW; // ter inistialisatie, bij initialisatie
										// null kwam null pointer exception

		for (int i = 0; i < (pad.length()); i++) {
			char nextStep = pad.charAt(i);
			move(huidig);
			frag = frag.makeStep(nextStep, huidig, this);
			loipe[x][y] = frag;
			if (nextStep == 'r') {
				huidig = huidig.turnRight();
			} else if (nextStep == 'l') {
				huidig = huidig.turnLeft();
			}
			puntArray[i] = new Punt(x,y);
		}
	}

	/**
	 * past de huidige x en y waarde aan door de verplaatsing
	 * @param d
	 */
	private void move(Direction d) {
		x += d.dx;
		y += d.dy;
	}

	/**
	 * als x kleiner is dan de huidige xmax verhoog xmax dan naar x, dit in verband met bochten
	 * @return ymin
	 */
	private int xMax() {
		if (x > xmax) {
			xmax = x;
		}
		return xmax;
	}

	/**
	 * als x kleiner is dan de huidige xmin verlaag xmin dan naar x
	 * @return xmin
	 */
	private int xMin() {
		if (x < xmin) {
			xmin = x;
		}
		return xmin;
	}

	/**
	 * als y groter is dan de huidige ymax verhoog ymin dan naar y
	 * @return ymax
	 */
	private int yMax() {
		if (y > ymax) {
			ymax = y;
		}
		return ymax;
	}

	/**
	 * als y kleiner is dan de huidige ymin verlaag ymin dan naar y
	 * @return ymin
	 */
	private int yMin() {
		if (y < ymin) {
			ymin = y;
		}
		return ymin;
	}

	public Fragment getLoipexy() {
		return loipe[x][y];
	}

	/**
	 * returned de start positie
	 */
	public Punt start() {
		x = Math.abs(xmin);
		y = Math.abs(ymin - 1);
		Punt start = new Punt(x, y);
		return start;
	}

	/**
	 * returned de stap op postitie i in de array van punten die bezocht zijn en waar een fragment staat 
	 */
	public Punt stap(int i) {
		Punt stap = puntArray[i];
		return stap;

	}

	public int getWidth() {
		return Math.abs(Math.abs(xmin - xmax) + 1);
	}

	public int getHeight() {
		return Math.abs(Math.abs(ymin - ymax) + 1);
	}

	public Fragment getFragment(int x, int y) {
		return (loipe[x][y]);
	}
}
