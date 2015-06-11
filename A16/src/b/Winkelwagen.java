package b;

import java.util.ArrayList;
import java.util.List;

public class Winkelwagen {
	/**
	 *
	 * @author Franka Buytenhuijs / s4356845
	 * @author Wesley van Hoorn / s4018044
	 */
	private List<Artikel> winkelwagen = new ArrayList<Artikel>();
	private Betaalmiddel betaalmiddel;
	private double totalcost = 0;
	public Winkelwagen() {
		betaalmiddel = new iDeal(totalcost);
	}

	/**
	 * voegt artikel a toe aan het winkelwagentje
	 * @param a
	 */
	public void addToCart(Artikel a) {
		winkelwagen.add(a);
	}

	/**
	 * Haalt artikel a uit het winkelwagentje
	 * @param a
	 */
	public void removeFromCart(Artikel a) {
		for(int i = 0; i<winkelwagen.size(); i++){
			if(winkelwagen.get(i) == a){
				winkelwagen.remove(i);
			}
		}
			
	}

	/*
	 * berekent de totale kosten voor de gebruiker
	 */
	public double totalCost() {
		double cost = 0;
		double delivercost = 0;
		for(Artikel art: winkelwagen){
			cost += art.cost();
			if(!(delivercost == 6.75) || !(delivercost == 30.0) || !(delivercost == 36.75)){
				delivercost += art.deliveryCost();
			}
		} 
		return cost + delivercost;
	}
	
	/**
	 * Zorgt dat de gebruiker kan betalen
	 */
	public void afrekenen(){
		totalcost = totalCost();
		System.out.println("De kosten zijn: " + totalcost);
		boolean gelukt = betaalmiddel.pay(totalcost);
		if(gelukt){
			System.out.println("De betaling is geslaagd, tot ziens");
			System.exit(0);
		}
		else{
			System.out.println("Helaas de betaling is niet gelukt, probeer opnieuw");
			afrekenen();
		}
	}
	
	public void setBetaalMiddelCreditCard(CreditCard bm){
		this.betaalmiddel = bm;
	}

	public void setBetaalMiddelPayPal(Paypal bm) {
		this.betaalmiddel = bm;
		
	}
	
	public void setBetaalMiddeliDeal(iDeal bm) {
		this.betaalmiddel = bm;
		
	}

}