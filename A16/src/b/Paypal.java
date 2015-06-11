package b;

public class Paypal extends Betaalmiddel {

	private String email;
	private String password;
	public Paypal(double price) {
		super(price);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean pay(double price) {
		// TODO Auto-generated method stub
		return false;
	}
	

}