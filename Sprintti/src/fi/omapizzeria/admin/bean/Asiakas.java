package fi.omapizzeria.admin.bean;

public class Asiakas {
	private int id;
	private int numero;
	
	private String email;
	
	private String etunimi;
	private String sukunimi;
	private String osoite;
	private String tmp;
	private int postinro;

	public Asiakas(int id,String etunimi, String sukunimi, int numero,  String email, String osoite, String tmp,
			int postinro) {
		this.id=id;
		this.numero = numero;
		this.email = email;
		this.etunimi=etunimi;
		this.sukunimi=sukunimi;
		this.osoite=osoite;
		this.tmp=tmp;
		this.postinro=postinro;
	}

	
	
	public Asiakas(int id,String etunimi, String sukunimi, int numero,  String email) {
		this.id=id;
		this.numero = numero;
		this.email = email;
		this.etunimi=etunimi;
		this.sukunimi=sukunimi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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



	public String getOsoite() {
		return osoite;
	}



	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}



	public String getTmp() {
		return tmp;
	}



	public void setTmp(String tmp) {
		this.tmp = tmp;
	}



	public int getPostinro() {
		return postinro;
	}



	public void setPostinro(int postinro) {
		this.postinro = postinro;
	}


}
