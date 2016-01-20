/**
 *
 * @author Pieter Koopman, Sjaak Smetsers
 */
public class Main
{

    public static void main(String[] args) {
        int [] game = {6,8,5, 4,1,2, 3,9,7};

        SlidingGame s = new SlidingGame (game);
        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}
