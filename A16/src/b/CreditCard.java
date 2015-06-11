package b;

public class CreditCard extends Betaalmiddel {

	private String name;
	private int cartnr;
	private int expiredate;
	public CreditCard(double price) {
		super(price);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean pay(double price) {
		// TODO Auto-generated method stub
		return false;
	}
	

}