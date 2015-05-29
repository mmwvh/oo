/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * OO1route66 initial class
 * 
 * @author Pieter Koopman
 *
 *         Enumeration class for driving directions
 */
public enum Direction {
	North, East, South, West;

	/**
	 * convert integer to direction if number of directions is 2 only East and
	 * West are used, otherwise all 4 directions are used
	 * 
	 * @param i
	 *            the integer
	 * @return the direction
	 */
	public static Direction intToDirection(int i) {
		if (Model.DIRECTIONS == 2) {
			switch (i % 2) {
			case 0:
				return East;
			default:
				return West;
			}
		} else {
			switch (i % 4) {
			case 0:
				return North;
			case 1:
				return East;
			case 2:
				return South;
			default:
				return West;
			}
		}
	}

	/**
	 * override standard toString
	 * 
	 * @return string representation of this value
	 */
	@Override
	public String toString() {
		switch (this) {
		case North:
			return "North";
		case East:
			return "East";
		case South:
			return "South";
		case West:
			return "West";
		default:
			return "Unknown direction";
		}
	}
}
