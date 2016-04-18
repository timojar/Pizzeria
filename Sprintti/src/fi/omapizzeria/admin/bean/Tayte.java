package fi.omapizzeria.admin.bean;

public class Tayte {
	
private String tayteNimi;

private int id, maara;


public Tayte(){
	
tayteNimi=null;
id=0;
maara=0;
	
}


public Tayte(String tayteNimi, int id){
	
this.tayteNimi=tayteNimi;
this.id=id;

	
}

public int getMaara() {
	return maara;
}


public void setMaara(int maara) {
	this.maara = maara;
}


public Tayte(String tayteNimi, int id, int maara){
	
this.tayteNimi=tayteNimi;
this.id=id;
this.maara=maara;
	
}

public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
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




	

}
