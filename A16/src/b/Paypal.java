package b;

import java.util.Scanner;

public class Paypal extends Betaalmiddel {

	private String email;
	private String password;
	public Paypal(double price) {
		super(price);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean pay(double price) {
		System.out.println("Geef uw mailadres");
		Scanner sc3 = new Scanner(System.in);
		String i3 = sc3.nextLine();
		System.out.println("Uw mailadres is: " + i3);
		
		System.out.println("Geef uw wachtwoord");
		Scanner sc = new Scanner(System.in);
		String i = sc.nextLine();
		System.out.println("Uw wachtwoord is: " + i);
		
		System.out.println("Is dit correct? Typ 1 voor ja en 2 voor nee.");
		Scanner sc4 = new Scanner(System.in);
		int i4 = sc4.nextInt();
		if (i4 == 1){
			return true;
		}
		else{return false;}
	}
	

}