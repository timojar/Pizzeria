package fi.omapizzeria.admin.bean;

public class Tilausrivi {

	private int PizzaId;
	private int TilausNro;
	
	public Tilausrivi(){
		
	}
	public Tilausrivi(int PizzaId, int TilausNro){
		this.PizzaId = PizzaId;
		this.TilausNro = TilausNro;
		
	}
	public int getPizzaId() {
		return PizzaId;
	}
	public void setPizzaId(int pizzaId) {
		PizzaId = pizzaId;
	}
	public int getTilausNro() {
		return TilausNro;
	}
	public void setTilausNro(int tilausNro) {
		TilausNro = tilausNro;
	}
	@Override
	public String toString() {
		return "Tilausrivi [PizzaId=" + PizzaId + ", TilausNro=" + TilausNro
				+ "]";
	}
	
}
