package fi.omapizzeria.admin.bean;


public class Admin {

	private int id;
	private String Kayttajanimi;
	private String Salasana;
	
	public Admin(){
		
	}
	public Admin(String Kayttajanimi, String Salasana){
		this.id = id;
		this.Kayttajanimi = Kayttajanimi;
		this.Salasana = Salasana;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKayttajanimi() {
		return Kayttajanimi;
	}
	public void setKayttajanimi(String kayttajanimi) {
		Kayttajanimi = kayttajanimi;
	}
	public String getSalasana() {
		return Salasana;
	}
	public void setSalasana(String salasana) {
		Salasana = salasana;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", Kayttajanimi=" + Kayttajanimi + ", Salasana=" + Salasana + "]";
	}

	
}