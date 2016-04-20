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
	
private List<Asiakas> Asiakkaat;	
	
	
	public String salaaTeksti (String salattavaTeksti, String Kayttajanimi) {
		Asiakkaat = new ArrayList<Asiakas>();
		String suola=null;
		String salasana=null;
		Salaus salaus=new Salaus();
		ConnectionFactory yhteys = new ConnectionFactory();
		int montakoKertaa=3;
		Connection conn;

		conn = yhteys.getConnection();
		String suolasql="SELECT Suola from Asiakas where Email=?";
		
		
		try {

		PreparedStatement suolahaku=conn.prepareStatement(suolasql);
		
	suolahaku.setString(1, Kayttajanimi);
	
	ResultSet result= suolahaku.executeQuery();
	
	while(result.next()){
		suola=result.getNString("Suola");
		
	}

	
	try {
		
		
		salasana=salaus.salaa(salattavaTeksti, suola, montakoKertaa);
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
			
			
		}

		catch (SQLException e) {

		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return salasana;}
	
	
	
public boolean vahvistaTunnus(String Salasana, String Kayttajanimi) {
	
	boolean asiakasvahvistus = false;
		ConnectionFactory yhteys = new ConnectionFactory();

		Connection conn;

		conn = yhteys.getConnection();
		
		
		try {

			String sql = "select  * from Asiakas;";

			Statement haku = conn.createStatement();

			ResultSet hakutulokset = haku.executeQuery(sql);

			
			while (hakutulokset.next()) {
				
		
				if (Kayttajanimi.equals(hakutulokset.getString("Email"))
						&& Salasana.equals(hakutulokset.getString("Salasana"))) {
					
					
					asiakasvahvistus=true;
				}

			
				
				
				
			}
	
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {yhteys.suljeYhteys(conn);}
		
		return asiakasvahvistus ;
	}
	
	
	
	
	
	
	
	
	
	public Asiakas  luoAsiakas(String etunimi, String sukunimi,  String email, String salattavaTeksti, int numero) {
		
		Asiakas asiakas=null;
		ConnectionFactory yhteys = new ConnectionFactory();

		Connection conn;

		conn = yhteys.getConnection();

		Salaus salaus= new Salaus();
		String suola=null;
		String salasana=null;
		int montakoKertaa=3;
		try {suola=salaus.generoiSuola();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
		}


		try {salasana=salaus.salaa(salattavaTeksti, suola, montakoKertaa);

		} catch (Exception e) {
			}

		asiakas=new Asiakas(etunimi, sukunimi,numero,email,salasana);
		try {
			
			
			String sql="insert into Asiakas (Email, Salasana, Suola, Etunimet, Sukunimi, Puhelin) values(?,?,?,?,?,?)";	
			PreparedStatement stmInsert = conn.prepareStatement(sql);
			stmInsert.setString(1, email);
			stmInsert.setString(2, salasana);
			stmInsert.setString(3, suola);
			stmInsert.setString(4, etunimi);
			stmInsert.setString(5, sukunimi);
			stmInsert.setInt(6, numero);
			stmInsert.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally{
			yhteys.suljeYhteys(conn);
		}
					
	return asiakas;
	
	}
	

}
