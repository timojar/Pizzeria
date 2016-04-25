package dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import salaus.Salaus;
import fi.omapizzeria.admin.bean.*;

public class AdminDao {

	private boolean vahvistus;
	private List<Admin> adminit;
	 
	 
	
	public void  createOwner(String etunimi, String sukunimi, String tehtava, String tunnus, String salattavaTeksti){
		
	
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


try {
	
	
	String sql="insert into Admin ( Kayttajanimi, Salasana, Suola, Etunimet, Sukunimi, Tehtava) values(?,?,?,?,?,?)";	
	PreparedStatement stmInsert = conn.prepareStatement(sql);
	stmInsert.setString(1, tunnus);
	stmInsert.setString(2, salasana);
	stmInsert.setString(3, suola);
	stmInsert.setString(4, etunimi);
	stmInsert.setString(5, sukunimi);
	stmInsert.setString(6, tehtava);
	stmInsert.executeUpdate();
	
} catch (SQLException e) {
	e.printStackTrace();
}

finally{
	yhteys.suljeYhteys(conn);
}
			
		
		
	}

	public String salaaTeksti (String salattavaTeksti, String Kayttajanimi) {
		adminit = new ArrayList<Admin>();
		String suola=null;
		String salasana=null;
		Salaus salaus=new Salaus();
		ConnectionFactory yhteys = new ConnectionFactory();
		int montakoKertaa=3;
		Connection conn;

		conn = yhteys.getConnection();
		String suolasql="SELECT Suola from Admin where Kayttajanimi=?";
		
		
		try {

		PreparedStatement suolahaku=conn.prepareStatement(suolasql);
		
	suolahaku.setString(1, Kayttajanimi);
	
	ResultSet result= suolahaku.executeQuery();
	System.out.println(salattavaTeksti);
	while(result.next()){
		
		
		suola=result.getString("Suola");
		
	}

	
	try {
		System.out.println("suolaluku "+ suola);
		
		salasana=salaus.salaa(salattavaTeksti, suola, montakoKertaa);
		System.out.println(salasana);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
			
			
		}

		catch (SQLException e) {
			
		e.printStackTrace();	
			

		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return salasana;
	}

	
	public boolean vahvistaTunnus(String Salasana, String Kayttajanimi) {
		
		ConnectionFactory yhteys = new ConnectionFactory();

		Connection conn;

		conn = yhteys.getConnection();
		boolean vahvistus=false;
		
		try {

			String sql = "select  * from Admin ;";

			Statement haku = conn.createStatement();

			ResultSet hakutulokset = haku.executeQuery(sql);

			
			while (hakutulokset.next()) {

		

				if (Kayttajanimi.equals(hakutulokset.getString("Kayttajanimi"))
						&& Salasana.equals(hakutulokset.getString("Salasana"))) {
					

					vahvistus=true;
				}

			}
	
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {yhteys.suljeYhteys(conn);}
		
		return vahvistus;
	}
	
	
	
	
	
	public boolean checkUser(String Kayttajanimi){
		
		ConnectionFactory yhteys = new ConnectionFactory();

		Connection conn;

		conn = yhteys.getConnection();
		
		boolean kayttvahvistus=false;
		
		

		try {

			String sql = "select  * from Admin ;";

			Statement haku = conn.createStatement();

			ResultSet hakutulokset = haku.executeQuery(sql);
		
			
			while (hakutulokset.next()) {

		

				if (Kayttajanimi.equals(hakutulokset.getString("Kayttajanimi")))
						 {
					

					kayttvahvistus=true;
					
					
				}

			}
	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {yhteys.suljeYhteys(conn);}
		
		return kayttvahvistus;
	}
		
		
		
		
	}
	
	
	

