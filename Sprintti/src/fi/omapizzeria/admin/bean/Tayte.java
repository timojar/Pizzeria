package fi.omapizzeria.admin.bean;

public class Tayte {
	
private String tayteNimi;

private int saatavuus;

private int id;


public Tayte(){
	
tayteNimi=null;

saatavuus=0;

id=0;
	
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public Tayte(String tayteNimi, int saatavuus){
	
this.tayteNimi=tayteNimi;

this.saatavuus=saatavuus;
	
}

public Tayte(String tayteNimi, int saatavuus, int id){
	
this.tayteNimi=tayteNimi;

this.saatavuus=saatavuus;

this.id=id;
	
}

public Tayte(String tayteNimi){
	
this.tayteNimi=tayteNimi;


	
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
