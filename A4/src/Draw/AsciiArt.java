package Draw;

import Enum.Fragment;
import Interface.InfoLoipe;
import Interface.TekenLoipe;

public class AsciiArt implements TekenLoipe {

	private Fragment[][] loipe;
	private int x;
	private int y;
	private InfoLoipe s;
	private char[][] parcours;

	public void setLoipe(InfoLoipe s) {
		this.x = s.getX();
		this.y = s.getY();
		loipe = new Fragment[x][y];
		this.s = s;
		parcours = new char[x][y];
		teken();
		print(); 

	}

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
					case KR:
						parcours[i][j] = '+';
						break;
					default:
						parcours[i][j] = ' ';

					}
				}
				else {
					parcours[i][j] = ' ' ;
				}
			}
		}
	}

	public void print() {
		for (int i = 0; i < x; i++) {

			for (int j = 0; j < y; j++) {
				System.out.print(parcours[i][j]);
			}
			System.out.println();
		}
	}
}
