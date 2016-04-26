package fi.omapizzeria.admin.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Tilaus {
	private int asiakasnumero;
	private int numero;
	private String  tilausajankohta;
	private String  toimitusajankohta;
	private String toimitustapa;
	private String maksutapa;
	private String status;
	private double yhteishinta;
	private Asiakas tilausAsiakas;
	
	
	
	public Tilaus(int asiakasnumero, int numero, String tilausajankohta, String toimitusajankohta,
			String toimitustapa, String maksutapa, double yhteishinta,String  status) {
		this.numero = numero;
		this.tilausajankohta = tilausajankohta;
		this.toimitusajankohta = toimitusajankohta;
		this.toimitustapa = toimitustapa;
		this.maksutapa = maksutapa;
		this.yhteishinta=yhteishinta;
		this.asiakasnumero=asiakasnumero;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Tilaus(Asiakas tilausAsiakas){
		this.tilausAsiakas=tilausAsiakas;
	}
	
	public Tilaus(int numero, String tilausajankohta, String toimitusajankohta,
			String toimitustapa, String maksutapa, double yhteishinta) {
		this.numero = numero;
		this.tilausajankohta = tilausajankohta;
		this.toimitusajankohta = toimitusajankohta;
		this.toimitustapa = toimitustapa;
		this.maksutapa = maksutapa;
		this.yhteishinta=yhteishinta;
	}
	
	
	
	public Tilaus(int numero, String tilausajankohta, String toimitusajankohta,
			String toimitustapa, String maksutapa, double yhteishinta, Asiakas tilausAsiakas) {
		this.numero = numero;
		this.tilausajankohta = tilausajankohta;
		this.toimitusajankohta = toimitusajankohta;
		this.toimitustapa = toimitustapa;
		this.maksutapa = maksutapa;
		this.yhteishinta=yhteishinta;
		this.tilausAsiakas=tilausAsiakas;
	}
	
	
	

	public double getYhteishinta() {
		return yhteishinta;
	}

	public void setYhteishinta(double yhteishinta) {
		this.yhteishinta = yhteishinta;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTilausajankohta() {
		return tilausajankohta;
	}

	public void setTilausajankohta(String tilausajankohta) {
		this.tilausajankohta = tilausajankohta;
	}

	public String getToimitusajankohta() {
		return toimitusajankohta;
	}

	public void setToimitusajankohta(String toimitusajankohta) {
		this.toimitusajankohta = toimitusajankohta;
	}

	public String getToimitustapa() {
		return toimitustapa;
	}

	public void setToimitustapa(String toimitustapa) {
		this.toimitustapa = toimitustapa;
	}

	public String getMaksutapa() {
		return maksutapa;
	}

	public void setMaksutapa(String maksutapa) {
		this.maksutapa = maksutapa;
	}
	
	
	public Asiakas getTilausAsiakas() {
		return tilausAsiakas;
	}

	public void setTilausAsiakas(Asiakas tilausAsiakas) {
		this.tilausAsiakas = tilausAsiakas;
	}


	public int getAsiakasnumero() {
		return asiakasnumero;
	}

	public void setAsiakasnumero(int asiakasnumero) {
		this.asiakasnumero = asiakasnumero;
	}

	@Override
	public String toString() {
		return "Tilaus [numero=" + numero + ", tilausajankohta="
				+ tilausajankohta + ", toimitusajankohta=" + toimitusajankohta
				+ ", toimitustapa=" + toimitustapa + ", maksutapa=" + maksutapa
				+ "]";
	}

}
