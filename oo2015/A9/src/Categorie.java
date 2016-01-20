/**
 * @author Franka Buytenhuijs, Wesley van Hoorn s4356845, s4018044
 *
 */

public enum Categorie {
	BOEKEN, NIET_BOEKEN;

	@Override
	public String toString() {
		// only capitalize the first letter
		String s = super.toString();
		return s.substring(0, 1) + s.substring(1).toLowerCase();
	}
}
