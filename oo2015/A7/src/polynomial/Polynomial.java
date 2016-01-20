package polynomial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * A skeleton class for representing Polynomials
 *
 * @author Franka Buytenhuijs, Wesley van Hoorn s4356845, s4018044
 * @author Sjaak Smetsers
 * @date 10-03-2015
 */
public class Polynomial {

	/**
	 * A polynomial is a sequence of terms here kept in an List
	 */
	List<Term> terms;

	/**
	 * A constructor for creating the zero Polynomial zero is presented as an
	 * empty list of terms and not as a single term with 0 as a coefficient
	 */
	public Polynomial() {
		terms = new ArrayList<>();
	}

	/**
	 * A Constructor creating a polynomial from the argument string.
	 *
	 * @param s
	 *            a String representing a list of terms which is converted to a
	 *            scanner and passed to scanTerm for reading each individual
	 *            term
	 */
	public Polynomial(String s) {
		terms = new ArrayList<>();
		Scanner scan = new Scanner(s);

		for (Term t = Term.scanTerm(scan); t != null; t = Term.scanTerm(scan)) {
			terms.add(t);
		}
	}

	/**
	 * The copy constructor for making a deep copy
	 *
	 * @param p
	 *            the copied polynomial
	 *
	 */
	public Polynomial(Polynomial p) {
		terms = new ArrayList<>(p.terms.size());
		for (Term t : p.terms) {
			terms.add(new Term(t));
		}
	}

	/**
	 * A straightforward conversion of a Polynomial into a string based on the
	 * toString for terms
	 *
	 * @return a readable string representation of this
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(terms.get(0).toString());
		for (int i = 1; i < terms.size(); i++) {
			if (terms.get(i).getCoef() > 0) {
				sb.append(" +");
			} else {
				sb.append(" ");
			}
			sb.append(terms.get(i).toString());
		}
		String s = sb.toString();
		return s;
	}

	/**
	 * Adds polynomial b to the current polynomial
	 * 
	 * @param b
	 *            the to be added polynomial
	 */
	public void plus(Polynomial b) {
		ListIterator<Term> it = terms.listIterator();
		boolean equals = false;
		ArrayList<Term> newTerms = new ArrayList<>();
		ArrayList<Term> newb = new ArrayList<>();
		while (it.hasNext()) {
			equals = false;
			ListIterator<Term> itb = b.terms.listIterator();
			Term s = it.next();
			while (itb.hasNext()) {
				Term t = itb.next();
				if (s.getExp() == t.getExp()) {
					s.plus(t);
					newTerms.add(s);
					newb.add(t);
					equals = true;
				}
			}
			if (!equals) {
				newTerms.add(s);
			}
		}
		for (Term t : b.terms) {
			equals = false;
			for (Term m : newb) {
				if (t == m) {
					equals = true;
				}
			}
			if (!equals) {
				newTerms.add(t);
			}
		}
		terms.clear();
		for (Term t : newTerms) {
			terms.add(t);
		}
		zeroClean();
		Collections.sort(terms);
	}

	/**
	 * Subtracts polynomial b from the current polynomial
	 * 
	 * @param b
	 *            the to be subtracted polynomial
	 */
	public void minus(Polynomial b) {
		Polynomial mineen = new Polynomial("-1 0");
		Polynomial copyB = new Polynomial();
		for (Term t : b.terms) {
			copyB.terms.add(t);
		}
		copyB.times(mineen);
		plus(copyB);
	}

	/**
	 * 
	 * Multiplies polynomial b to the current polynomial
	 * 
	 * @param b
	 *            the to be multiplied polynomial
	 */
	public void times(Polynomial b) {
		ArrayList<Term> newTerms = new ArrayList<>();
		for (Term t : terms) {
			for (Term m : b.terms) {
				Term newT = new Term(t.getCoef(), t.getExp());
				newT.times(m);
				newTerms.add(newT);
			}
		}
		terms.clear();
		for (Term t : newTerms) {
			terms.add(t);
		}
		timesClean();
	}

	/**
	 * Withholds the time function to multiply the same value multiple times
	 */
	public void timesClean() {
		for (int i = 0; i < terms.size(); i++) {
			for (int j = i + 1; j < terms.size(); j++) {
				if (terms.get(i).getExp() == terms.get(j).getExp()) {
					terms.get(i).plus(terms.get(j));
					terms.set(j, new Term(0, 0));
				}
			}
		}
		zeroClean();
	}

	/**
	 * Cleanses the current polynomial from zeroes.
	 */
	public void zeroClean() {
		ArrayList<Term> rm = new ArrayList<>();
		for (Term t : terms) {
			if (t.getCoef() == 0) {
				rm.add(t);

			}
		}
		terms.removeAll(rm);
		if (terms.isEmpty()) {
			terms.add(new Term(0, 0));
		}

	}

	/**
	 * 
	 * @param value
	 *            for the polynomial
	 * @return the solution of the polynomial of value
	 */
	public double apply(int value) {
		double waarde = 0;
		for (Term t : terms) {
			waarde += t.getCoef() * (Math.pow(value, t.getExp()));
		}
		return waarde;
	}
}
