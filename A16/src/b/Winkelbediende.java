package b;

import java.util.Scanner;

public class Winkelbediende {

	/**
	 *
	 * @author Franka Buytenhuijs / s4356845
	 * @author Wesley van Hoorn / s4018044
	 */
	private Winkelwagen wg;
	public Winkelbediende(Winkelwagen wg){
		this.wg = wg;
		Welkom();
	}
	
	/**
	 * laat welkoms bericht zien en vraagt de gebruiker wat hij wil deon
	 */
	public void Welkom(){
		System.out.println("Wat wilt u doen?");
		System.out.println("Toets 1 voor winkelen, toets 2 voor afrekenen");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		if(i == 1){
			artikelKopen();
		}
		else if(i == 2){
			kiesBetaalMiddel();
			wg.afrekenen();
		}
	}
	
	/**
	 * vraagt de gebruiker hoe hij wil betalen
	 */
	public void kiesBetaalMiddel(){
		System.out.println("Hoe wilt u betalen ");
		System.out.println("Kies 1 voor: Ideal \nKies 2 voor: PayPal \nKies 3 voor: CreditCard ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		if(i == 1){
			wg.setBetaalMiddeliDeal(new iDeal(0));
		}
		else if(i == 2){
			wg.setBetaalMiddelPayPal(new Paypal(0));
		}
		else if (i==3){
			wg.setBetaalMiddelCreditCard(new CreditCard(0));
		}
		else {
			System.out.println("Verkeerde invoer, probeer het opnieuw.");
			kiesBetaalMiddel();
		}
	}
	
	/**
	 * vraagt de gebruiker welk artikel hij wil kopen
	 */
	public void artikelKopen(){
		Artikel a;
		
		System.out.println("Welk artikel wilt u kopen? ");
		System.out.println("Kies 1 voor: Wasmachine \nKies 2 voor: Wijnglazen \nKies 3 voor: Watermeloen ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		if(i == 1){
			wg.addToCart(new Wasmachine());
			Welkom();
		}
		else if(i == 2){
			wg.addToCart(new Wijnglazen());
			Welkom();
		}
		else if (i==3){
			wg.addToCart(new Watermeloen());;
			Welkom();
		}
		else {
			System.out.println("Verkeerde invoer, probeer het opnieuw.");
			artikelKopen();
		}
	}
}
