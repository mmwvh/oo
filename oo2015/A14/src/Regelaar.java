/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
public class Regelaar {

	private boolean vrijNZ = true;
	private boolean vrijEW = true;

	private int crossed = 0;

	public Regelaar() {

	}

	/*
	 * Disable the other directions
	 */
	public boolean enterCross(Direction d) {
		if (d == Direction.North || d == Direction.South) {

			if (vrijEW) {
				vrijNZ = false;
				return true;
			}
			return false;
		}

		else if (d == Direction.East || d == Direction.West) {

			if (vrijNZ) {
				vrijEW = false;
				return true;
			}
			return false;
		}
		return false;
	}

	/*
	 * Switch lanes after some cars left the intersection
	 */
	public boolean leftCross(Direction d) {
		crossed += 1;
		if (crossed > 5) {
			if (d == Direction.North || d == Direction.South) {

				vrijNZ = true;
				vrijEW = false;
				System.out.println("NZ " + crossed + " vrij " + vrijNZ);
			}
			else if (d == Direction.West || d == Direction.East) {

				vrijEW = true;
				vrijNZ = false;
				System.out.println("EW " + crossed + " vrij " + vrijEW);
			}
			crossed = 0;
			return false;
		}
		return true;
	}
}