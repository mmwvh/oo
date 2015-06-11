package a;
import java.util.LinkedList;
import java.util.List;


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
