/**
 * 
 */
package opg02;

import opg01.Student;

/**
 * @author Wesley van Hoorn, 4018044
 *
 */
public class Board {

	private final int M;
	private final int N;

	private int[][] board;

	public Board(int m, int n) {

		this.M = m;
		this.N = n;
		this.board = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = 0;
			}
		}
	}

	public boolean isWinBounds(Pos p) {
		return (p.getX() >= 0 && p.getX() < M && p.getY() >= 0 && p.getY() < N);
	}
	
	public boolean isClosed() {
		for (int i = 0; i < M; i++) {
			for(int j =0; j < N; j++) {
				if(board[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	

	public void set(Pos p, int n) {
		board[p.getX()][p.getY()] = n;
	}

	public int get(Pos p) {
		return board[p.getX()][p.getY()];
	}

	public int getM() {
		return M;
	}

	public int getN() {
		return N;
	}

	@Override
	public String toString() {
		String c = "";
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				c += board[i][j] + "  ";
			}
			c += "\n";
		}
		return c;
	}
}
