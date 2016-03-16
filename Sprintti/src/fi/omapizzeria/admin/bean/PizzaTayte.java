package fi.omapizzeria.admin.bean;

public class PizzaTayte {

	private String TayteNimi;
	private int saatavuus;

	public PizzaTayte() {

	}

	public PizzaTayte(String TayteNimi, int saatavuus) {

		this.TayteNimi = TayteNimi;
		this.saatavuus = saatavuus;

	}

	public String getTayteNimi() {
		return TayteNimi;
	}

	public void setTayteNimi(String tayteNimi) {
		TayteNimi = tayteNimi;
	}

	public int getSaatavuus() {
		return saatavuus;
	}

	public void setSaatavuus(int saatavuus) {
		this.saatavuus = saatavuus;
	}

	@Override
	public String toString() {
		return "PizzaTayte [TayteNimi=" + TayteNimi + ", saatavuus="
				+ saatavuus + "]";
	}

}
