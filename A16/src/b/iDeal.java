package b;

public class iDeal extends Betaalmiddel {

	private String bank;
	private int accountnr;
	private int pin;
	public iDeal(double price) {
		super(price);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public boolean pay(double price) {
		
		return false;
	}
	
	
	

}