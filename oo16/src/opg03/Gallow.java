/**
 * 
 */
package opg03;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class Gallow {

	private WoordLezer read;
	private StringBuilder good = new StringBuilder();
	private StringBuilder bad = new StringBuilder();
	private String ugly;

	public Gallow() {
		read = new WoordLezer("woorden.txt");
		this.ugly = read.geefWoord();
		dots();
	}

	public Gallow(String s) {
		this.ugly = s;
		dots();
	}

	private void dots() {
		for (int i = 0; i < ugly.length(); i++) {
			good.append(" # ");
		}
	}

	public boolean isDuplicate(String s, char c) {
		return s.indexOf(c) != -1;
	}

	public boolean won() {
		return good.toString().equals(ugly);
	}

	public boolean dead() {
		return bad.length() > 7;
	}

	public void setGoodChar(int i, char e) {
		good.setCharAt(i, e);
	}

	public void setBadChar(char e) {
		bad.append(e);
	}

	public StringBuilder getGood() {
		return good;
	}

	public StringBuilder getBad() {
		return bad;
	}

	public String getUgly() {
		return ugly;
	}
}
