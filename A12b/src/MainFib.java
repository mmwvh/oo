/**
 *
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */

public class MainFib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ParFib f = new ParFib(21);
			Thread t = new Thread(f);
			t.start();
			t.join();
			System.out.println(f.getAnswer());
		} catch (Exception e) {
			System.out.println("usage: java Fib NUMBER");
		}
	}
}
