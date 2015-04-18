import java.io.Serializable;

/**
 * @author Franka Buytenhuijs, Wesley van Hoorn s4356845, s4018044
 *
 */

public class Gebruiker implements Serializable {

	private int UserID;

	public Gebruiker(int ID){
		this.UserID = ID;
	}
	public int getUserID() {
		return this.UserID;
	}

	/**
	 * 
	 * @param UserID
	 */
	public void setUserID(int id) {
		this.UserID = id;
	}
}