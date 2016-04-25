package fi.omapizzeria.admin.bean;

public class KantaAsiakas extends Asiakas {
	
	private String salasana;	
	
public KantaAsiakas(int id, String etunimi, String sukunimi, int numero,  String email, String salasana)	{
	
super(id, etunimi, sukunimi, numero, email);	
this.salasana=salasana;
}

public String getSalasana() {
	return salasana;
}

public void setSalasana(String salasana) {
	this.salasana = salasana;
}

}
