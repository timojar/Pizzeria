package fi.omapizzeria.admin.bean;

public class Juoma {

	private int id;
	private String nimi;

	public Juoma() {

	}

	public Juoma(int id, String nimi) {
		this.id = id;
		this.nimi = nimi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return "Juoma [id=" + id + ", nimi=" + nimi + "]";
	}

}
