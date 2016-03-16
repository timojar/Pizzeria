package fi.omapizzeria.admin.bean;

public class Admin {

	private String Kayttajanimi;
	private String Salasana;
	
	public Admin(){
		
	}
	public Admin(String Kayttajanimi, String Salasana){
		this.Kayttajanimi = Kayttajanimi;
		this.Salasana = Salasana;
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
		return "Admin [Kayttajanimi=" + Kayttajanimi + ", Salasana=" + Salasana
				+ "]";
	}
	
}
