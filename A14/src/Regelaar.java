/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pieterkoopman
 */
public class Regelaar {
	private Object noordZuid = new Object();
	private Object ossWest = new Object();
	private int crossNZ = 0;
	private int crossEW = 0;
	private int crossedNZ = 0;
	private int crossedEW = 0;
	private boolean vrijNZ = true;
	private boolean vrijEW = true;

	public Regelaar() {

	}

	public void cross(Direction d) {
		if (d == Direction.North || d == Direction.South) {
			crossNZ += 1;
			System.out.println("NZ " + crossNZ);
			if (vrijEW || crossedNZ > 5) {
				crossedNZ = 0;
				vrijNZ = false;
				try {
					synchronized (noordZuid) {
						noordZuid.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		} else if (d == Direction.East || d == Direction.West) {
			crossEW += 1;
			System.out.println("EW " + crossEW);
			if (vrijNZ || crossedEW > 5) {
				crossedEW = 0;
				vrijEW = false;
				try {
					synchronized (ossWest) {
						ossWest.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void leave(Direction d) {
		if (d == Direction.North || d == Direction.South) {
			crossNZ -= 1;
			crossedNZ += 1;
			
			vrijNZ = true;
			vrijEW = false;
			
			synchronized (ossWest) {
				ossWest.notifyAll();
			}
		}
		if (d == Direction.West || d == Direction.East) {
			crossEW -= 1;
			crossedEW += 1;

			synchronized (noordZuid) {
				noordZuid.notifyAll();
			}
		}

	}
}
