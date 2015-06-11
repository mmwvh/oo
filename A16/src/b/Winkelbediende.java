package b;

import java.util.Scanner;

public class Winkelbediende {

	
	private Winkelwagen wg;
	public Winkelbediende(Winkelwagen wg){
		this.wg = wg;
	}
	
	
	public void Welkom(){
		System.out.println("Welkom in de winkel. Wat wilt u doen?");
		System.out.println("Toets 1 voor winkelen, toets 2 voor afrekenen");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		if(i == 1){
			artikelKopen();
		}
		else if(i == 2){
			wg.totalCost();
		}
	}
	
	
	public Artikel artikelKopen(){
		Artikel a;
		
		System.out.println("Welk artikel wilt u kopen? ");
		System.out.println("Kies 1 voor: Wasmachine \nKies 2 voor: Wijnglazen \nKies 3 voor: Watermeloen ");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		if(i == 1){
			return new Wasmachine();
		}
		else if(i == 2){
			return new Wijnglazen();
		}
		else if (i==3){
			return new Watermeloen();
		}
		else {return null;}
	}
}
