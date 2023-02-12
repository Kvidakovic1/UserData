package data.model;

public abstract class Entitet {
	public int id;

	public Entitet() {
		super();
	}

	public Entitet(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
