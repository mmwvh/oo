/**
 * Een Punt in 2D
 * @author pieter koopman
 */
 
public class Point {
    private int x, y;

    /**
     * de gewone constructor
     * @param i: x
     * @param j; y
     */
    public Point(int i, int j) {
        x = i;
        y = j;
    }
    
    /**
     * copy constructor
     * @param p 
     */
    public Point (Point p) {
        if (p != null) {
            x = p.x;
            y = p.y;
        } else {
            x = y = 0;
        }
    }
    
    /**
     * getter voor x
     * @return x
     */
    public int getX (){
        return x;
    }
    
    /**
     * getter voor y
     * @return y
     */
    public int getY (){
        return y;
    }
    
    /**
     * equals methode vergelijkt x en y
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Point) {
            Point p = (Point) o;
            return x == p.x && y == p.y;
        } else {
            return false;
        }
    }
    
    /**
     * Punt naar String conversie
     * @return Strin met waarde van x en y
     */
    @Override
    public String toString () {
        return "(" + x + "," + y + ")";
    }
}