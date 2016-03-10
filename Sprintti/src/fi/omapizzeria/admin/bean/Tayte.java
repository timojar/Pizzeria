package fi.omapizzeria.admin.bean;

public class Tayte {
	
private String tayteNimi;

private int saatavuus;


public Tayte(){
	
tayteNimi=null;

saatavuus=0;
	
}


public Tayte(String tayteNimi, int saatavuus){
	
this.tayteNimi=tayteNimi;

this.saatavuus=saatavuus;
	
}


public String getTayteNimi() {
	return tayteNimi;
}


public void setTayteNimi(String tayteNimi) {
	this.tayteNimi = tayteNimi;
}


public int getSaatavuus() {
	return saatavuus;
}


public void setSaatavuus(int saatavuus) {
	this.saatavuus = saatavuus;
}


	

}
