package fi.omapizzeria.admin.bean;

public class Tilausrivi {

	private int pizzaid;
	private int tilausNro;
	private int lkm;
	private Pizza pizza;
	double hinta;
	
	public Tilausrivi(){
		
	}
	public Tilausrivi(int pizzaid, int TilausNro){
		this.pizzaid = pizzaid;
		this.tilausNro = TilausNro;
		
	}
	
	public Tilausrivi(int pizzaid, int TilausNro, Pizza pizza, int lkm, double hinta){
		this.pizzaid = pizzaid;
		this.tilausNro = TilausNro;
		this.pizza=pizza;
		this.lkm=lkm;
		this.hinta=hinta;
	}
	
	public double getHinta() {
		return hinta;
	}
	public void setHinta(double hinta) {
		this.hinta = hinta;
	}
	public int getLkm() {
		return lkm;
	}
	public void setLkm(int lkm) {
		this.lkm = lkm;
	}
	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public int getPizzaid() {
		return pizzaid;
	}
	public void setPizzaid(int pizzaid) {
		this.pizzaid = pizzaid;
	}
	public int getTilausNro() {
		return tilausNro;
	}
	public void setTilausNro(int tilausNro) {
		this.tilausNro = tilausNro;
	}
	
}
