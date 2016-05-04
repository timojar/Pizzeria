package fi.omapizzeria.admin.bean;

public class PizzaTayte {

	private String tayteNimi;
	private int pizzaid;
	private int tayteid;
	private String pizzanimi;
	
	public PizzaTayte(){
		tayteNimi="";
		pizzaid=0;
		tayteid=0;
		pizzanimi="";
		
	}
	
	public PizzaTayte (String tayteNimi, int pizzaid, int tayteid, String pizzanimi){
		
	this.tayteNimi=tayteNimi;
	this.pizzaid=pizzaid;
	this.tayteid=tayteid;
	this.pizzanimi=pizzanimi;
		
		
	}

	public String getTayteNimi() {
		return tayteNimi;
	}

	public void setTayteNimi(String tayteNimi) {
		this.tayteNimi = tayteNimi;
	}

	public int getPizzaid() {
		return pizzaid;
	}

	public void setPizzaid(int pizzaid) {
		this.pizzaid = pizzaid;
	}

	public int getTayteid() {
		return tayteid;
	}

	public void setTayteid(int tayteid) {
		this.tayteid = tayteid;
	}

	public String getPizzanimi() {
		return pizzanimi;
	}

	public void setPizzanimi(String pizzanimi) {
		this.pizzanimi = pizzanimi;
	}

	
	
}