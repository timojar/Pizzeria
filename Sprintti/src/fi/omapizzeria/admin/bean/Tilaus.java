package fi.omapizzeria.admin.bean;

import java.util.Date;

public class Tilaus {

	private int numero;
	private Date tilausajankohta;
	private Date toimitusajankohta;
	private int toimitustapa;
	private int maksutapa;

	public Tilaus() {

	}

	public Tilaus(int numero, Date tilausajankohta, Date toimitusajankohta,
			int toimitustapa, int maksutapa) {
		this.numero = numero;
		this.tilausajankohta = tilausajankohta;
		this.toimitusajankohta = toimitusajankohta;
		this.toimitustapa = toimitustapa;
		this.maksutapa = maksutapa;

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getTilausajankohta() {
		return tilausajankohta;
	}

	public void setTilausajankohta(Date tilausajankohta) {
		this.tilausajankohta = tilausajankohta;
	}

	public Date getToimitusajankohta() {
		return toimitusajankohta;
	}

	public void setToimitusajankohta(Date toimitusajankohta) {
		this.toimitusajankohta = toimitusajankohta;
	}

	public int getToimitustapa() {
		return toimitustapa;
	}

	public void setToimitustapa(int toimitustapa) {
		this.toimitustapa = toimitustapa;
	}

	public int getMaksutapa() {
		return maksutapa;
	}

	public void setMaksutapa(int maksutapa) {
		this.maksutapa = maksutapa;
	}

	@Override
	public String toString() {
		return "Tilaus [numero=" + numero + ", tilausajankohta="
				+ tilausajankohta + ", toimitusajankohta=" + toimitusajankohta
				+ ", toimitustapa=" + toimitustapa + ", maksutapa=" + maksutapa
				+ "]";
	}

}
