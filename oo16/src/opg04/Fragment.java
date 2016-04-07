/**
 * 
 */
package opg04;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public enum Fragment {

	NZ, OW, NO, NW, ZO, ZW, KR;

	public Fragment update(Richting rOld, Richting rNew) {
		switch (rOld) {
		case N:
			switch (rNew) {
			case E:
				return Fragment.NO;
			case W:
				return Fragment.NW;
			default:
				return Fragment.NZ;
			}
		case E:
			switch (rNew) {
			case N:
				return Fragment.NO;
			case S:
				return Fragment.ZO;
			default:
				return Fragment.OW;
			}
		case S:
			switch (rNew) {
			case E:
				return Fragment.ZO;
			case W:
				return Fragment.ZW;
			default:
				return Fragment.NZ;
			}
		case W:
			switch (rNew) {
			case N:
				return Fragment.NW;
			case S:
				return Fragment.ZW;
			default:
				return Fragment.OW;
			}
		default:
			return null;
		}
	}
}
