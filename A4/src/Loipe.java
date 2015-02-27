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

	public Loipe(String pad) {
		this.pad = pad;
		loipeSize();
		loipe = new Fragment[Math.abs(xmin - xmax) + 1][Math.abs(ymin - ymax) + 1];
		loipeFill();
	}

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

	private void loipeFill() {
		x = Math.abs(xmin);
		y = Math.abs(ymin - 1);
		huidig = Direction.N;

		for (int i = 0; i < (pad.length()); i++) {
			char nextStep = pad.charAt(i);
			move(huidig);

			switch (huidig) {
			case Z:
				if (nextStep == 'r') {

					loipe[x][y] = Fragment.NW;
					huidig = huidig.turnRight();
				} else if (nextStep == 'l') {

					loipe[x][y] = Fragment.NO;
					huidig = huidig.turnLeft();
				} else {
					crossNZ(x, y);
				}

				break;
			case O:
				if (nextStep == 'r') {

					loipe[x][y] = Fragment.ZW;
					huidig = huidig.turnRight();

				} else if (nextStep == 'l') {

					loipe[x][y] = Fragment.NW;
					huidig = huidig.turnLeft();
				} else {
					crossOW(x, y);
				}

				break;
			case W:
				if (nextStep == 'r') {

					loipe[x][y] = Fragment.NO;
					huidig = huidig.turnRight();
				} else if (nextStep == 'l') {

					loipe[x][y] = Fragment.ZO;
					huidig = huidig.turnLeft();
				} else {
					crossOW(x, y);
				}

				break;
			default:
				if (nextStep == 'r') {

					loipe[x][y] = Fragment.ZO;
					huidig = huidig.turnRight();
				} else if (nextStep == 'l') {

					loipe[x][y] = Fragment.ZW;
					huidig = huidig.turnLeft();
				} else {
					crossNZ(x, y);
				}

				break;
			}
		}
	}

	private void move(Direction d) {
		x += d.dx;
		y += d.dy;
	}

	private int xMax() {
		if (x > xmax) {
			xmax = x;
		}
		return xmax;
	}

	private int xMin() {
		if (x < xmin) {
			xmin = x;
		}
		return xmin;
	}

	private int yMax() {
		if (y > ymax) {
			ymax = y;
		}
		return ymax;
	}

	private int yMin() {
		if (y < ymin) {
			ymin = y;
		}
		return ymin;
	}

	private void crossNZ(int x, int y) {
		if (loipe[x][y] != null) {
			loipe[x][y] = Fragment.KR;
		} else {
			loipe[x][y] = Fragment.NZ;
		}

	}

	private void crossOW(int x, int y) {
		if (loipe[x][y] != null) {
			loipe[x][y] = Fragment.KR;
		} else {
			loipe[x][y] = Fragment.OW;
		}
	}

	public Punt start() {
		x = Math.abs(xmin);
		y = Math.abs(ymin - 1);
		Punt start = new Punt(x, y);
		return start;
	}

	public Punt stap() {
		Punt stap = new Punt(x,y);
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
