package fi.omapizzeria.admin.bean;

public class Pizza {
	
private int id;

private String nimi, kuvaus, poisto;

private double hinta;


public Pizza(){
	
id=0;

nimi="";
	
hinta=0;

kuvaus="";
}

public Pizza(int id, String nimi, double hinta){
	
this.id=id;

this.nimi=nimi;

this.hinta=hinta;
	
}



public Pizza(int id, String nimi, double hinta, String kuvaus, String poisto){
	
this.id=id;

this.nimi=nimi;

this.hinta=hinta;
this.kuvaus=kuvaus;

this.poisto=poisto;
	
}


public String getPoisto() {
	return poisto;
}

public void setPoisto(String poisto) {
	this.poisto = poisto;
}

public Pizza(int id, String nimi, double hinta, String kuvaus){
	
this.id=id;

this.nimi=nimi;

this.hinta=hinta;
this.kuvaus=kuvaus;
	
}




public Pizza(String nimi, double hinta){
	

this.nimi=nimi;

this.hinta=hinta;
	
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

public double getHinta() {
	return hinta;
}

public void setHinta(double hinta) {
	this.hinta = hinta;
}

public String getKuvaus() {
	return kuvaus;
}



}
