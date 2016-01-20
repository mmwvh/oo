/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */

public class ParFib implements Runnable {

	private int n;
	private long answer;

	public ParFib(int n) {
		this.n = n;
	}
	
	/**
	 * Calculates the Fibonacci number
	 */
	private void Fib() {
		if (n < 2)
			answer = 0;
		if (n <= 3)
			answer = 1;
		else {
			try {
				ParFib pf1 = new ParFib(n - 1);
				ParFib pf2 = new ParFib(n - 2);
				Thread f1 = new Thread(pf1);
				Thread f2 = new Thread(pf2);
				f1.start();
				f2.start();
				f1.join();
				f2.join();
				answer = pf1.getAnswer() + pf2.getAnswer();
			} catch (InterruptedException ex) {
			}
		}
	}

	@Override
	public void run() {
		Fib();
	}

	public long getAnswer() {
		return answer;
	}

}
