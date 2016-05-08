package dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.admin.bean.*;
import salaus.Salaus;

public class AsiakasDAO {

	private List<Asiakas> Asiakkaat, asiakaslista;
	private List<KantaAsiakas> KantaAsiakkaat;

	public Asiakas tuoTilaaja(int asiakasnumero) {
		Connection conn;
		ConnectionFactory yhteys = new ConnectionFactory();
		conn = yhteys.getConnection();

		Asiakas asiakas = null;
		ResultSet rs = null;
		String sql = "select  * from Asiakas where id = ?;";
		System.out.println("toimiiko" + asiakasnumero);
		try {

			PreparedStatement userSearch = conn.prepareStatement(sql);
			userSearch.setInt(1, asiakasnumero);
			int id = asiakasnumero;
			rs = userSearch.executeQuery();

			while (rs.next()) {

				String etunimi = rs.getString("Etunimet");
				String sukunimi = rs.getString("Sukunimi");
				String numero = rs.getString("Puhelin");
				String email = rs.getString("Email");
				String osoite = rs.getString("osoite");
				String tmp = rs.getString("tmp");
				String postinro = rs.getString("postinro");
				asiakas = new Asiakas(id, etunimi, sukunimi, numero, email,
						osoite, tmp, postinro);
				System.out.println("Kirjautuminen" + osoite);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return asiakas;
	}

	public KantaAsiakas getAsiakas(String Kayttajanimi) {
		String etunimi = null, sukunimi = null, salasana = null;
		String numero = "";
		int id = 0;
		ConnectionFactory yhteys = new ConnectionFactory();
		String email = Kayttajanimi;
		Connection conn;

		conn = yhteys.getConnection();

		KantaAsiakas asiakas = null;
		ResultSet rs = null;
		String sql = "select  * from KantaAsiakas where Email = ?;";
		try {

			PreparedStatement userSearch = conn.prepareStatement(sql);
			userSearch.setString(1, email);

			rs = userSearch.executeQuery();

			while (rs.next()) {

				etunimi = rs.getString("Etunimet");
				sukunimi = rs.getString("Sukunimi");
				salasana = rs.getString("Salasana");
				numero = rs.getString("Puhelin");
				id = rs.getInt("id");
				asiakas = new KantaAsiakas(id, etunimi, sukunimi, numero,
						email, salasana);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return asiakas;

	}

	public boolean checkUser(String email) {

		ConnectionFactory yhteys = new ConnectionFactory();

		Connection conn;

		conn = yhteys.getConnection();

		boolean kayttvahvistus = false;

		try {

			String sql = "select  * from KantaAsiakas;";

			Statement haku = conn.createStatement();

			ResultSet hakutulokset = haku.executeQuery(sql);

			while (hakutulokset.next()) {

				if (email.equals(hakutulokset.getString("Email"))) {

					kayttvahvistus = true;

				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return kayttvahvistus;
	}

	public String salaaTeksti(String salattavaTeksti, String Kayttajanimi) {

		String suola = null;
		String salasana = null;
		Salaus salaus = new Salaus();
		ConnectionFactory yhteys = new ConnectionFactory();
		int montakoKertaa = 3;
		Connection conn;

		conn = yhteys.getConnection();
		String suolasql = "SELECT Suola from KantaAsiakas where Email=?";

		try {

			PreparedStatement suolahaku = conn.prepareStatement(suolasql);

			suolahaku.setString(1, Kayttajanimi);

			ResultSet result = suolahaku.executeQuery();

			while (result.next()) {
				suola = result.getString("Suola");

			}

			try {

				salasana = salaus.salaa(salattavaTeksti, suola, montakoKertaa);

			} catch (Exception e) {
				// TODO: handle exception
			}

		}

		catch (SQLException e) {

		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return salasana;
	}

	public boolean vahvistaTunnus(String Salasana, String Kayttajanimi) {

		boolean asiakasvahvistus = false;
		ConnectionFactory yhteys = new ConnectionFactory();

		Connection conn;

		conn = yhteys.getConnection();

		try {

			String sql = "select  * from KantaAsiakas;";

			Statement haku = conn.createStatement();

			ResultSet hakutulokset = haku.executeQuery(sql);

			while (hakutulokset.next()) {

				if (Kayttajanimi.equals(hakutulokset.getString("Email"))
						&& Salasana.equals(hakutulokset.getString("Salasana"))) {

					asiakasvahvistus = true;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return asiakasvahvistus;
	}

	public KantaAsiakas luoAsiakas(String etunimi, String sukunimi,
			String email, String salattavaTeksti, String numero,
			String toimosoite, String postitmp, String postinro) {

		KantaAsiakas asiakas = null;
		ConnectionFactory yhteys = new ConnectionFactory();

		Connection conn;

		conn = yhteys.getConnection();

		Salaus salaus = new Salaus();
		String suola = null;
		String salasana = null;
		int id = 0;

		asiakaslista = haeAsiakkaat();

		if (asiakaslista.size() > 0) {
			Asiakas a = asiakaslista.get(asiakaslista.size() - 1);

			id = a.getId() + 1;
		} else {
			id = 1;
		}

		int montakoKertaa = 3;
		try {
			suola = salaus.generoiSuola();

		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
		}

		try {
			salasana = salaus.salaa(salattavaTeksti, suola, montakoKertaa);

		} catch (Exception e) {
		}

		asiakas = new KantaAsiakas(id, etunimi, sukunimi, numero, email,
				salasana);

		System.out.println("Postitoimipaikka " + postitmp);
		insertAsiakas(email, etunimi, sukunimi, numero, id, toimosoite,
				postitmp, postinro);
		if (salattavaTeksti != null) {
			insertKantaAsiakas(email, salasana, suola, etunimi, sukunimi,
					numero, id);
		}

		return asiakas;

	}

	private void insertKantaAsiakas(String email, String salasana,
			String suola, String etunimi, String sukunimi, String numero, int id) {

		ConnectionFactory yhteys = new ConnectionFactory();

		Connection conn;

		conn = yhteys.getConnection();

		try {

			String sql = "insert into KantaAsiakas (Email, Salasana, Suola, Etunimet, Sukunimi, Puhelin, id) values(?,?,?,?,?,?,?)";
			PreparedStatement stmInsert = conn.prepareStatement(sql);
			stmInsert.setString(1, email);
			stmInsert.setString(2, salasana);
			stmInsert.setString(3, suola);
			stmInsert.setString(4, etunimi);
			stmInsert.setString(5, sukunimi);
			stmInsert.setString(6, numero);
			stmInsert.setInt(7, id);
			stmInsert.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

			// TODO: handle exception
		}

		finally {
			yhteys.suljeYhteys(conn);

		}
	};

	private void insertAsiakas(String email, String etunimi, String sukunimi,
			String numero, int id, String toimosoite, String postitmp,
			String postinro) {

		ConnectionFactory yhteys = new ConnectionFactory();

		Connection conn;

		conn = yhteys.getConnection();

		try {

			String sql = "insert into Asiakas (Email,  Etunimet, Sukunimi, Puhelin, id, osoite, tmp, postinro ) values(?,?,?,?,?,?,?,?)";
			PreparedStatement stmInsert = conn.prepareStatement(sql);
			stmInsert.setString(1, email);
			stmInsert.setString(2, etunimi);
			stmInsert.setString(3, sukunimi);
			stmInsert.setString(4, numero);
			stmInsert.setInt(5, id);
			stmInsert.setString(6, toimosoite);
			stmInsert.setString(7, postitmp);
			stmInsert.setString(8, postinro);
			stmInsert.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

			// TODO: handle exception
		}

		finally {
			yhteys.suljeYhteys(conn);

		}
	};

	private List<Asiakas> haeAsiakkaat() {

		ConnectionFactory yhteys = new ConnectionFactory();

		Connection conn;

		conn = yhteys.getConnection();

		int id;
		String numero;
		String email;
		String etunimi;
		String sukunimi;
		asiakaslista = new ArrayList<Asiakas>();

		try {

			String sql = "select  * from Asiakas;";

			Statement haku = conn.createStatement();

			ResultSet hakutulokset = haku.executeQuery(sql);

			while (hakutulokset.next()) {

				id = hakutulokset.getInt("id");
				etunimi = hakutulokset.getString("Etunimet");
				sukunimi = hakutulokset.getString("Sukunimi");
				email = hakutulokset.getString("Email");
				numero = hakutulokset.getString("Puhelin");

				asiakaslista.add(new Asiakas(id, etunimi, sukunimi, numero,
						email));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return asiakaslista;
	};

	
	
	
	public void MuokkaAsiakas(int asiakasnumero, String etunimi, String sukunimi,
			String email,  String numerostr,
			String toimosoite, String postitmp, String postinro)
	
	{
		
		Connection conn;		
		ConnectionFactory yhteys = new ConnectionFactory();	
		
				
		conn = yhteys.getConnection();

			try {
				String sql = "Update Asiakas set Email = ?, Etunimet = ?, Sukunimi = ?, Puhelin = ?, osoite = ?, tmp = ?, postinro = ? where id = ?";
				
				
				PreparedStatement stmupdate = conn.prepareStatement(sql);
				stmupdate.setString(1, email);
				stmupdate.setString(2, etunimi);
				stmupdate.setString(3, sukunimi);
				stmupdate.setString(4, numerostr);
				stmupdate.setString(5, toimosoite);
				stmupdate.setString(6, postitmp);
				stmupdate.setString(7, postinro);
				stmupdate.setInt(8, asiakasnumero);
				stmupdate.executeUpdate();

				
				
			}
			
			catch (Exception e) {
			e.printStackTrace();
				System.out.println("Palautus ei onnistunut");	
				
			}
			
			finally {
				yhteys.suljeYhteys(conn);
			}	
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
