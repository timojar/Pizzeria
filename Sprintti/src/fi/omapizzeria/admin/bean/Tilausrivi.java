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
	public void setPizzaId(int PizzaId) {
		this.PizzaId = PizzaId;
	}
	public int getTilausNro() {
		return TilausNro;
	}
	public void setTilausNro(int TilausNro) {
		this.TilausNro = TilausNro;
	}
	@Override
	public String toString() {
		return "Tilausrivi [PizzaId=" + PizzaId + ", TilausNro=" + TilausNro
				+ "]";
	}
	
}
