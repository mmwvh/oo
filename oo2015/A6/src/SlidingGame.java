import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.2
 * @date 28-02-2015 A template implementation of a sliding game also
 *       implementing the Graph interface
 */
public class SlidingGame implements Configuration {
	public static final int N = 3, SIZE = N * N, HOLE = SIZE;
	/*
	 * The board is represented by a 2-dimensional array; the position of the
	 * hole is kept in 2 variables holeX and holeY
	 */
	private int[][] board;
	private int holeX, holeY;

	/*
	 * A constructor that initializes the board with the specified array
	 * 
	 * @param start: a one dimensional array containing the initial board. The
	 * elements of start are stored row-wise.
	 */
	public SlidingGame(int[] start) {
		board = new int[N][N];

		assert start.length == N * N : "Length of specified board incorrect";

		for (int p = 0; p < start.length; p++) {
			board[p % N][p / N] = start[p];
			if (start[p] == HOLE) {
				holeX = p % N;
				holeY = p / N;
			}
		}
	}

	public SlidingGame(int[][] b, int newHX, int newHY) {
		board = new int[N][N];
		holeX = newHX;
		holeY = newHY;
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (b[i][j] == HOLE) {
					board[i][j] = b[newHX][newHY];
				} else {
					board[i][j] = b[i][j];
				}
			}
		}
		board[newHX][newHY] = HOLE;
	}

	/*
	 * Converts a board into a printable representation. The hole is displayed
	 * as a space
	 * 
	 * @return the string representation
	 */
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				int puzzel = board[col][row];
				buf.append(puzzel == HOLE ? "  " : puzzel + " ");
			}
			buf.append("\n");
		}
		return buf.toString();
	}

	/*
	 * a standard implementation of equals checking whether 2 boards are filled
	 * in exactly the same way
	 * 
	 * @return a boolean indicating equality
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) {
			return false;
		} else {
			SlidingGame other_puzzle = (SlidingGame) o;
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (board[col][row] != other_puzzle.board[col][row]) {
						return false;
					}
				}
			}
			return true;
		}
	}

	@Override
	public boolean isSolution() {

		int v = 1;
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (board[i][j] != v && (i < N && j < N)) {
					return false;
				}
				v++;
			}
		}
		return true;
	}

	@Override
	public Collection<Configuration> successors() {
		LinkedList<Configuration> s = new LinkedList<Configuration>();

		for (Direction dir : Direction.values()) {
			if (holeX + dir.GetDX() >= 0 && holeX + dir.GetDX() < N) {
				if (dir.GetDX() != 0) {
					s.add(new SlidingGame(board, holeX + dir.GetDX(), holeY));
				}
				if (holeY + dir.GetDY() >= 0 && holeY + dir.GetDY() < N) {
					if (dir.GetDY() != 0) {
						s.add(new SlidingGame(board, holeX, holeY + dir.GetDY()));
					}
				}
			}
		}
		return s;
	}

	private int manhattanHeuristic() {
		int h = 0;
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				int target = board[i][j];
				int solutionX = (target - 1) % N;
				int solutionY = (target - 1) / N;

				h += Math.abs(i - solutionX) + Math.abs(j - solutionY);
			}
		}
		return h;
	}

	@Override
	public int compareTo(Configuration g) {
		return 0;
	}

	@Override
	public int hashCode() {
		int h = 0;
		for (int j = 0; j < N - 1; j++) {
			for (int i = 0; i < N - 1; i++) {
				h += board[i][j] * Math.pow(31, (i + j * N));
			}
		}
		return h;
	}
}
