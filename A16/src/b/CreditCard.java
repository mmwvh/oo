package b;

import java.util.Scanner;

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
		System.out.println("Geef uw naam");
		Scanner sc3 = new Scanner(System.in);
		String i3 = sc3.nextLine();
		System.out.println("Uw naam is: " + i3);
		
		System.out.println("Geef uw kaart nummer");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println("Uw kaart nummer is: " + i);
		
		System.out.println("Geef uw verloopdatum");
		Scanner sc2 = new Scanner(System.in);
		int i2 = sc.nextInt();
		System.out.println("Uw verloopdatum is: " + i2);
		
		System.out.println("Is dit correct? Typ 1 voor ja en 2 voor nee.");
		Scanner sc4 = new Scanner(System.in);
		int i4 = sc4.nextInt();
		if (i4 == 1){
			return true;
		}
		else{return false;}
	}
	

}