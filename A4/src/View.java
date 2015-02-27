/**
 * Object Orientation Artificial Intelligence
 * 
 * @author Franka Buytenhuijs / s4356845
 * @author Wesley van Hoorn / s4018044
 * 
 */
import java.util.Scanner;


public class View {

	public View(){
	    
	} 
	/**
	 * wacht op user input
	 * @return TRUE als user input gegeven heeft
	 */
	public boolean input(){
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Druk 2x op enter voor de volgende stap");
	    String readString = scanner.nextLine();
	    if (scanner.hasNextLine()){
	         return true;
	        }
	    return false;
	           
	        
	   
	   
	}
	
	
}
