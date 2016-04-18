package fi.omapizzeria.admin.bean;

public class RaakaAine {
	
private int id;

private String nimi;

private int saatavuus;


public RaakaAine(){
id=0;
nimi="";
saatavuus=0;	
	
}

public RaakaAine(int id, String nimi, int saatavuus){

this.id=id;	
this.nimi=nimi;
this.saatavuus=saatavuus;
	
}


public RaakaAine(String nimi, int saatavuus){


this.nimi=nimi;
this.saatavuus=saatavuus;
	
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

public int getSaatavuus() {
	return saatavuus;
}

public void setSaatavuus(int saatavuus) {
	this.saatavuus = saatavuus;
}
	
	

}
