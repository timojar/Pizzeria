package fi.omapizzeria.admin.bean;

public class Asiakas {

	private int numero;
	
	private String email;
	private String salasana;
	private String etunimi;
	private String sukunimi;

	private Asiakas() {

	}

	public Asiakas(String etunimi, String sukunimi, int numero,  String email, String salasana) {
		this.numero = numero;
		this.email = email;
		this.salasana = salasana;
		this.etunimi=etunimi;
		this.sukunimi=sukunimi;
	}

	@Override
	public String toString() {
		return "Asiakas [numero=" + numero + ", email=" + email + ", salasana="
				+ salasana + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ "]";
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	
}
