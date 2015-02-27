
public class AsciiArt implements TekenLoipe {

	private Fragment[][] loipe;
	private int x;
	private int y;
	private InfoLoipe s;
	private char[][] parcours;
	private int i;

	/**
	 * initialiseerd de array voor de ascii tekens met de juiste grootte 
	 * @param s
	 */
	public void setLoipe(InfoLoipe s) {
		this.x = s.getWidth();
		this.y = s.getHeight();
		loipe = new Fragment[x][y];
		this.s = s;
		parcours = new char[x][y];
	}
/**
 * zet alle juiste ascii tekens op de goede plaats
 */
	public void teken() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				Fragment frag = s.getFragment(i, j);
				if (frag != null) {
					switch (frag) {
					case NZ:
						parcours[i][j] = '|';
						break;
					case OW:
						parcours[i][j] = '-';
						break;
					case NW:
						parcours[i][j] = ',';
						break;
					case NO:
						parcours[i][j] = '`';
						break;
					case ZO:
						parcours[i][j] = '/';
						break;
					case ZW:
						parcours[i][j] = '.';
						break;
					default:
						parcours[i][j] = '+';
						break;
					}
				} else {
					parcours[i][j] = ' ';
				}
			}
		}
	}
	
	/**
	 * print het parcours in ascii style
	 */
	public void print() {
		for (int j = 0; j < y; j++) {
			for (int i = 0; i < x; i++) {
				System.out.print(parcours[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * zet op de volgende plaats een * neer
	 */
	public void setPosition(Punt p) {
		
		int x = p.getX();
		int y = p.getY();
		this.teken();
		parcours[x][y] = '*';
		this.print();
	
		}
}
