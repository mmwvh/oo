package a;
import java.util.LinkedList;
import java.util.List;

/**
*
* @author Franka Buytenhuijs / s4356845
* @author Wesley van Hoorn / s4018044
*/
public class IjsjesMaker {

	public static void main(String[] args) {
			List<Ijsje> Ijsjes = new LinkedList<>();
			Ijsjes.add(new Chocodip(new Slagroom(new Yoghurtijs())));
			
			for(Ijsje ijs:Ijsjes){
				int prijs = ijs.cost();
				System.out.println(ijs + ". Dit kost: " + prijs + " cent");
				
		}

	}

}
