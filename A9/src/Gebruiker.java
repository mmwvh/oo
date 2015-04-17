public class Gebruiker {

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