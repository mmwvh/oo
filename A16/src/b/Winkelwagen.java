package b;

import java.util.ArrayList;
import java.util.List;

public class Winkelwagen {

	private List<Artikel> winkelwagen = new ArrayList<Artikel>();
	private Betaalmiddel betaalmiddel;
	private double totalcost = 0;
	public Winkelwagen() {
		betaalmiddel = new iDeal(totalcost);
	}

	public void addToCart(Artikel a) {
		winkelwagen.add(a);
	}

	public void removeFromCart(Artikel a) {
		for(int i = 0; i<winkelwagen.size(); i++){
			if(winkelwagen.get(i) == a){
				winkelwagen.remove(i);
			}
		}
			
	}

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
	
	public void afrekenen(){
		totalcost = totalCost();
		betaalmiddel.pay(totalcost);
	}

}