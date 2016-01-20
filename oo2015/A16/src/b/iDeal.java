package b;

import java.util.Scanner;
/**
*
* @author Franka Buytenhuijs / s4356845
* @author Wesley van Hoorn / s4018044
*/
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
		
		System.out.println("Geef uw bank");
		Scanner sc3 = new Scanner(System.in);
		String i3 = sc3.nextLine();
		System.out.println("Uw bank is: " + i3);
		
		System.out.println("Geef uw rekening nummer");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println("Uw rekening nummer is: " + i);
		
		System.out.println("Geef uw pin");
		Scanner sc2 = new Scanner(System.in);
		int i2 = sc.nextInt();
		System.out.println("Uw pin is: " + i2);
		
		System.out.println("Is dit correct? Typ 1 voor ja en 2 voor nee.");
		Scanner sc4 = new Scanner(System.in);
		int i4 = sc4.nextInt();
		if (i4 == 1){
			return true;
		}
		else{return false;}
	}
	
	
	

}