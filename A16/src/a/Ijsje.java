package a;
public abstract class Ijsje {

	private String description;

	@Override
	public String toString() {
		return "Onbekend ijsje";
	}

	public abstract int cost();

	protected String getDescription() {
		return this.description;
	}

}