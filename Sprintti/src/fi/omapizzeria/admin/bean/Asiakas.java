package fi.omapizzeria.admin.bean;

public class Asiakas {

	private int numero;
	private String nimi;
	private String email;
	private String salasana;

	private Asiakas() {

	}

	private Asiakas(int numero, String nimi, String email, String salasana) {
		this.numero = numero;
		this.nimi = nimi;
		this.email = email;
		this.salasana = salasana;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	@Override
	public String toString() {
		return "Asiakas [numero=" + numero + ", nimi=" + nimi + ", email="
				+ email + "]";
	}

}
