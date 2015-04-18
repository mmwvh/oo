import java.io.Serializable;

/**
 *
 * @author Franka Buytenhuijs, Wesley van Hoorn s4356845, s4018044
 * @author Sjaak Smetsers
 */
public class Artikel implements Serializable {
	private String artNaam;
	private Categorie categorie;
	private Double prijs;

	/**
	 * 
	 * @param n
	 * @param c
	 * @param p
	 */
	public Artikel(String n, double p, Categorie c) {

		artNaam = n;
		prijs = p;
		categorie = c;
	}

	/**
	 * 
	 * @param n Artikel naam
	 */
	public void setArtNaam(String n) {
		this.artNaam = n;
	}

	/**
	 * 
	 * @param p Artikel prijs
	 */
	public void setPrijs(double p) {
		this.prijs = p;
	}

	/**
	 * 
	 * @param c Artikel categorie
	 */
	public void setCategorie(Categorie c) {
		this.categorie = c;
	}

	@Override
	public String toString() {
		return artNaam + " " + prijs + "eu, " + categorie;
	}
}