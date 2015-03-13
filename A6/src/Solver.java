import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * A class that implements a breadth-first search algorithm
 * for finding the Configurations for which the isSolution predicate holds
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.3
 * @date 28-02-2013
 */
public class Solver
{
    // A queue for maintaining graphs that are not visited yet.
    Queue<Node<Configuration>> toExamine;
    Collection<Configuration> Examined;
    SlidingGame sg; 

    public Solver(Configuration g) {
    	toExamine = new PriorityQueue<Node<Configuration>>();
    	toExamine.add(new Node<Configuration>(null, g));
    	Examined = new HashSet<Configuration>();
    }
    
    /* A skeleton implementation of the solver
     * @return a string representation of the solution
     */
    public String solve () {
        while (! toExamine.isEmpty() ) {
            Node<Configuration> next = toExamine.remove();
            Configuration next_config = next.getItem();
            if ( next_config.isSolution() ) {
                System.out.println(next.toString());
            	return "Success!";
            } else {
                for ( Configuration succ: next_config.successors() ) {
                	if(!Examined.contains(succ)) {
                        Examined.add(succ);
                		toExamine.add(new Node<Configuration>(next, succ));
                	}
                    
                }
            }
        }
        return "Failure!";
    }
}
