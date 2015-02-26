import Enum.Fragment;
import Enum.Richting;
import Interface.InfoLoipe;

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
	private Richting huidig = Richting.N;
	private Fragment[][] loipe;

	public Loipe(String pad) {
		this.pad = pad;
		loipeSize();
		loipe = new Fragment[Math.abs(xmin - xmax) + 1][Math.abs(ymin - ymax) + 1];
		loipeFill();
	}

	private void loipeSize() {

		for (int i = 0; i < (pad.length() - 1); i++) {
			char nextStep = pad.charAt(i);

			switch (huidig) {
			case Z:
				if (nextStep == 'r') {
					huidig = Richting.W;
				} else if (nextStep == 'l') {
					huidig = Richting.O;
				}
				subY();

				break;
			case O:
				if (nextStep == 'r') {
					huidig = Richting.Z;
				} else if (nextStep == 'l') {
					huidig = Richting.N;
				}
				addX();
				break;
			case W:
				if (nextStep == 'r') {
					huidig = Richting.N;
				} else if (nextStep == 'l') {
					huidig = Richting.Z;
				}
				subX();
				break;
			default:
				if (nextStep == 'r') {
					huidig = Richting.O;
				} else if (nextStep == 'l') {
					huidig = Richting.W;
				}
				addY();
				break;
			}
		}
	}

	private void loipeFill() {
		int x = Math.abs(xmin), y = Math.abs(ymax-1);
		huidig = Richting.N;
		for (int i = 0; i < (pad.length() - 1); i++) {
			char nextStep = pad.charAt(i);

			switch (huidig) {
			case Z:
				y--;
				if (nextStep == 'r') {

					loipe[x][y] = Fragment.NW;
					huidig = Richting.W;
				} else if (nextStep == 'l') {

					loipe[x][y] = Fragment.NO;
					huidig = Richting.O;
				} else
					crossNZ();
				break;
			case O:
				x++;
				if (nextStep == 'r') {

					loipe[x][y] = Fragment.ZW;
					huidig = Richting.Z;
				} else if (nextStep == 'l') {

					loipe[x][y] = Fragment.NW;
					huidig = Richting.N;
				} else
					crossOW();
				break;
			case W:
				x--;
				if (nextStep == 'r') {

					loipe[x][y] = Fragment.NO;
					huidig = Richting.N;
				} else if (nextStep == 'l') {

					loipe[x][y] = Fragment.ZO;
					huidig = Richting.Z;
				} else
					crossOW();
				
				break;
			default:
				y++;
				if (nextStep == 'r') {

					loipe[x][y] = Fragment.ZO;
					huidig = Richting.O;
				} else if (nextStep == 'l') {

					loipe[x][y] = Fragment.ZW;
					huidig = Richting.W;
				} else 
					crossNZ();
				
				break;
			}
		}
	}

	private void addX() {
		x++;
		if (x > xmax) {
			xmax = x;
		}
	}

	private void subX() {
		x--;
		if (x < xmin) {
			xmin = x;
		}
	}

	private void addY() {
		y++;
		if (y > ymax) {
			ymax = y;
		}
	}

	private void subY() {
		y--;
		if (y < ymin) {
			ymin = y;
		}
	}

	private void crossNZ() {
		if (loipe[x][y] != null) {
			loipe[x][y] = Fragment.KR;
		} else
			loipe[x][y] = Fragment.NZ;
		
	}

	private void crossOW() {
		if (loipe[x][y] != null) {
			loipe[x][y] = Fragment.KR;
		} else
			loipe[x][y] = Fragment.OW;
	}

	public int getX() {
		return Math.abs(Math.abs(xmin - xmax) + 1);
	}

	public int getY() {
		return Math.abs(Math.abs(ymin - ymax) + 1);
	}

	public Fragment getFragment(int x, int y) {
		return (loipe[x][y]);
	}
}
