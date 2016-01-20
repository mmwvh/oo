/**
 * 
 */
package polynomial;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Franka Buytenhuijs, Wesley van Hoorn s4356845, s4018044
 */
public class PolynomialTest {

	Polynomial p0;
	Polynomial p00;
	Polynomial p1;
	Polynomial p2;
	Polynomial p22;
	Polynomial p3;
	Polynomial p33;
	Polynomial p4;
	Polynomial p5;
	Polynomial p6;
	Polynomial p7;
	Polynomial p8;

	@Before
	public void setUp() {
		p0 = new Polynomial("1 0");
		p00 = new Polynomial("1 0");
		p1 = new Polynomial("0 1");
		p2 = new Polynomial("1 3");
		p22 = new Polynomial("1 3");
		p3 = new Polynomial("-1 2");
		p33 = new Polynomial("-1 2");
		p4 = new Polynomial("-2 2");
		p5 = new Polynomial("2 2");
		p6 = new Polynomial("2 2 3 3 2 4");
		p7 = new Polynomial("3 2 3 1 4 3");
		p8 = new Polynomial("2 -2");
	}

	/**
	 * Test method for {@link polynomial.Polynomial#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("toString van 1*x^0: ", "1.000000", p0.toString());
		assertEquals("toString van 0*x^n", "0", p1.toString());
		assertEquals("toString van 1*x^n:", "x^3", p2.toString());
		assertEquals("toString van -1*x^n:", "-x^2", p3.toString());
		assertEquals("toString van -n*x^n:", "-2.000000x^2", p4.toString());
	}

	/**
	 * Test method for {@link polynomial.Polynomial#plus(polynomial.Polynomial)}
	 * .
	 */
	@Test
	public void testPlus() {
		p4.plus(p5);
		assertEquals("Som is 0", p4.toString(), "0");
		p8.plus(p1);
		assertEquals("Additive identity", p8.toString(), "2.000000x^-2");
		p2.plus(p5);
		p5.plus(p2);
		assertEquals("Commutativity", p2.toString(), p5.toString());
		p0.plus(p3);
		p0.plus(p8);
		p3.plus(p8);
		p3.plus(p00);
		assertEquals("Associativity", p0.toString(), p3.toString());
	}

	/**
	 * Test method for
	 * {@link polynomial.Polynomial#minus(polynomial.Polynomial)}.
	 */
	@Test
	public void testMinus() {
		p5.minus(p5);
		assertEquals(p5.toString(), "0");
		p0.minus(p1);
		assertEquals(p0.toString(), "1.000000");
		p6.minus(p7);
		assertEquals(p6.toString(), "-3.000000x -x^2 -x^3 +2.000000x^4");

	}

	/**
	 * Test method for
	 * {@link polynomial.Polynomial#times(polynomial.Polynomial)}.
	 */
	@Test
	public void testTimes() {
		p2.plus(p5);
		p2.times(p3);
		p3.times(p22);
		p33.times(p5);
		p3.plus(p33);
		assertEquals("Distributivity", p2.toString(), p3.toString());
		p4.times(p00);
		assertEquals("Multiplicative identity", p4.toString(), "-2.000000x^2");
		p6.times(p7);
		assertEquals(p6.toString(),
				"15.000000x^4 +6.000000x^3 +23.000000x^5 +18.000000x^6 +8.000000x^7");
		p8.times(p5);
		assertEquals(p8.toString(), "4.000000");
	}

	/**
	 * Test method for {@link polynomial.Polynomial#apply(int)}.
	 */
	@Test
	public void testApply() {
		assertEquals(p2.apply(2), 8.0, 0.0000005);
	}
}
