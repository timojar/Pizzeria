package fi.omapizzeria.admin.bean;

public class Pizza {
	
private int id, pizzaNo;

private String nimi, kuvaus, piiloitus;

private double hinta;


public Pizza(){
	
id=0;
pizzaNo=0;
nimi="";
	
hinta=0;

kuvaus="";

piiloitus="";
}

public Pizza(int id, String nimi, double hinta){
	
this.id=id;

this.nimi=nimi;

this.hinta=hinta;
	
}



public Pizza(int id, String nimi, double hinta, String kuvaus, String piiloitus){
	
this.id=id;

this.nimi=nimi;

this.hinta=hinta;
this.kuvaus=kuvaus;

this.piiloitus=piiloitus;
	
}


public String getPiiloitus() {
	return piiloitus;
}

public void setPoisto(String piiloitus) {
	this.piiloitus = piiloitus;
}

public Pizza(int id, String nimi, double hinta, String kuvaus){
	
this.id=id;

this.nimi=nimi;

this.hinta=hinta;
this.kuvaus=kuvaus;
	
}


public int getPizzaNo() {
	return pizzaNo;
}

public void setPizzaNo(int pizzaNo) {
	this.pizzaNo = pizzaNo;
}

public Pizza(int id, String nimi, double hinta, String kuvaus, int pizzaNo){
	
this.id=id;
this.pizzaNo=pizzaNo;

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
