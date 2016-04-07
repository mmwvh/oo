/**
 * 
 */
package opg06;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.3
 * @date 07-03-2016 A template implementation of a sliding game also
 *       implementing the Graph interface
 */
public class SlidingGame implements Configuration {
	public static final int N = 3, SIZE = N * N, HOLE = SIZE;
	/**
	 * The board is represented by a 2-dimensional array; the position of the
	 * hole is kept in 2 variables holeX and holeY
	 */
	private int[][] board;
	private int holeX, holeY;

	/**
	 * A constructor that initializes the board with the specified array
	 *
	 * @param start:
	 *            a one dimensional array containing the initial board. The
	 *            elements of start are stored row-wise.
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

	public SlidingGame(int[][] parent, int newHoleX, int newHoleY) {
		board = new int[N][N];
		holeX = newHoleX;
		holeY = newHoleY;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (parent[col][row] == HOLE) {
					board[col][row] = parent[newHoleX][newHoleY];
				} else {
					board[col][row] = parent[col][row];
				}
			}
		}
		board[newHoleX][newHoleY] = HOLE;
	}

	/**
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

	/**
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

	public boolean isSolution() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (board[col][row] > (row * col))
					return false;
			}
		}
		return true;
	}

	public Collection<Configuration> successors() {
		int holeDX, holeDY;
		LinkedList<Configuration> succ = new LinkedList<Configuration>();
		for (Direction dir : Direction.values()) {
			holeDX = holeX + dir.GetDX();
			holeDY = holeY + dir.GetDY();
			if (holeDX >= 0 && holeDY >= 0 && holeDX < N && holeDY < N) {
				succ.add(new SlidingGame(board, holeDX, holeDY));
			}
		}
		return succ;
	}

	@Override
	public int compareTo(Configuration g) {
		throw new UnsupportedOperationException("compareTo : not supported yet.");
	}

}
