package main;

import polynomial.Polynomial;

/**
 * 
 * @author Franka Buytenhuijs, Wesley van Hoorn s4356845, s4018044
 * @author Sjaak Smetsers
 */
public class Main {

	public static void main(String[] args) {
		Polynomial p1 = new Polynomial("3.0 1 2 3");
		Polynomial p2 = new Polynomial("4 0 5 3");
		Polynomial p3 = new Polynomial("4 0 -5 3");
		Polynomial p4 = new Polynomial("6 1");
		Polynomial p5 = new Polynomial("-2 2");
		Polynomial p6 = new Polynomial("2 2");
		Polynomial p7 = new Polynomial("1 3");
		Polynomial p8 = new Polynomial("2 2 3 3 2 4");
		Polynomial p9 = new Polynomial("3 2 3 1 4 3");
		Polynomial p10 = new Polynomial("2 -2");
		Polynomial p11 = new Polynomial("0 1");

		/*
		 * System.out.println( p1 ); System.out.println( p2 );
		 * System.out.println( p3 ); System.out.println( p4 );
		 */
		p6.apply(2);

		System.out.println(p6.apply(2));

	}

}
