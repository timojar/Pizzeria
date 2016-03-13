package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import fi.omapizzeria.admin.bean.Pizza;

public class PizzaDAO {

	private  Pizza pizza;

	private  List<Pizza> pizzalista, selaus;
	
	private int noofPizzas , nextIndex, pizzasperPage;
	
	

	
	public void poistaPiiloitus(int paljastaid){
		
Connection conn;		
ConnectionFactory yhteys = new ConnectionFactory();	
String palautus=null;
		
conn = yhteys.getConnection();

	try {
		String hide = "Update Pizza set poisto = ? where id = ?";
		
		
		PreparedStatement stmthide = conn.prepareStatement(hide);
		stmthide.setString(1, palautus);
		stmthide.setInt(2, paljastaid);
		stmthide.executeUpdate();

		System.out.println(paljastaid);
		
	}
	
	catch (Exception e) {
	e.printStackTrace();
		System.out.println("Palautus ei onnistunut");	
		
	}
	
	finally {
		yhteys.suljeYhteys(conn);
	}
	
	}
	
		
	
	
	
	public void piilotaPizza(int poistoid){
	
Connection conn;		
ConnectionFactory yhteys = new ConnectionFactory();	
		
conn = yhteys.getConnection();

	try {
		String hide = "Update Pizza set poisto = 'nosale' where id = ?";
		
		
		PreparedStatement stmthide = conn.prepareStatement(hide);
		stmthide.setInt(1, poistoid);
		stmthide.executeUpdate();

		System.out.println(poistoid);
		
	}
	
	catch (Exception e) {
	e.printStackTrace();
		System.out.println("Piilotus ei onnistunut");	
		
	}
	
	finally {
		yhteys.suljeYhteys(conn);
	}
	
	}
	
	
	
	public int getnoofPizzas (){
		
		Connection conn;
		
		ConnectionFactory yhteys = new ConnectionFactory();	
		
		conn = yhteys.getConnection();

		
		
		try {
			String sql = "select * from Pizza";

			Statement lkmHaku = conn.createStatement();

			ResultSet lkm = lkmHaku.executeQuery(sql);	
			
			while (lkm.next()) {
				
			 noofPizzas=lkm.getRow();
				 
				
			}
			
			
			
		}
		
		catch (Exception e){
		System.out.println("Virhe");	
			
			
			
		}
		
		finally{
			yhteys.suljeYhteys(conn);
		}
		
		
	return noofPizzas;	
	}
	
	

	public  List<Pizza> haePizzat(int nextIndex, int pizzasperPage) 
	
	
	{

		ConnectionFactory yhteys = new ConnectionFactory();
		pizzalista = new ArrayList<Pizza>();

		Connection conn;

		conn = yhteys.getConnection();

		try {

			String sql = "select SQL_CALC_FOUND_ROWS * from Pizza limit "+nextIndex+","+pizzasperPage
	                 ;
			
			

			Statement haku = conn.createStatement();
				
			ResultSet hakutulokset = haku.executeQuery(sql);

			while (hakutulokset.next()) {

				int id = hakutulokset.getInt("id");

				String nimi = hakutulokset.getString("nimi");

				double hinta = hakutulokset.getDouble("hinta");
				String kuvaus = hakutulokset.getString("kuvaus");
				String poisto = hakutulokset.getString("poisto");
				pizzalista.add(new Pizza(id, nimi, hinta,kuvaus, poisto));

			}

		} catch (SQLException e) {

			e.printStackTrace();

			System.out.println("Tietokantahaku aiheutti virheen");

		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return pizzalista;
	}

	
	
	
	
	public  void lisaaPizza(String nimi, double hinta, String kuvaus) {

		ConnectionFactory yhteys = new ConnectionFactory();
		pizzalista = new ArrayList<Pizza>();

		Connection conn;

		conn = yhteys.getConnection();

		int pizzalkm=0;
		
		
		
		try {
			
			String sql = "select * from Pizza";
			Statement lkmHaku = conn.createStatement();
			ResultSet lkm = lkmHaku.executeQuery(sql);	
			
			while (lkm.next()) {
			 pizzalkm=lkm.getRow();
			}
			
			int id=pizzalkm+1;
			
			String sqlInsert = "INSERT INTO pizza(id, nimi, hinta, kuvaus) VALUES (?, ?, ?,?)";
			PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
			stmtInsert.setInt(1, id);
			stmtInsert.setString(2, nimi);
			stmtInsert.setDouble(3, hinta);
			stmtInsert.setString(4, kuvaus);
			stmtInsert.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Lis‰minen ei onnistunut");
		}

		finally {

			yhteys.suljeYhteys(conn);

		}

	}

	/**
	 * pizzanpoisto: Otetaan Pizza id vastaan parametrina
	 */
	public void poistaPizza(int id) {

		ConnectionFactory yhteys = new ConnectionFactory();
		Connection conn;

		conn = yhteys.getConnection();

		/**
		 * pizzanpoisto: Yritt‰m‰ll‰ poistetaan pizza ja sen Pizza-id numeroita
		 * pit‰‰ j‰rjstell‰ uudelleen.
		 */

		try {
			selaus = new ArrayList<Pizza>();

			String sqldelete = "delete from pizza where id=?";
			PreparedStatement stmtdelete = conn.prepareStatement(sqldelete);
			stmtdelete.setInt(1, id);
			stmtdelete.executeUpdate();

			/**
			 * pizzanpoisto: Haetaan pizzalista tietokannasta selaamalla, jotta
			 * voidaan j‰rjestell‰ id-numeroita uudelleen.
			 */

			String sql = "select * from Pizza";

			Statement haku = conn.createStatement();

			ResultSet hakutulokset = haku.executeQuery(sql);

			while (hakutulokset.next()) {

				id = hakutulokset.getInt("id");

				String nimi = hakutulokset.getString("nimi");

				double hinta = hakutulokset.getDouble("hinta");

				selaus.add(new Pizza(id, nimi, hinta));

			}

			/**
			 * pizzanpoisto: K‰yd‰‰n pizzat loopissa l‰pi. odlID ottaa seuraavan
			 * numeron ja laittaa sit‰ edellisen numeron tilalle
			 */

			int t = 0;

			while (t < selaus.size()) {

				t++;

				/**
				 * Edelliset tunnukset ei muutu, koska id on primary key ja
				 * kahta samaa tunnusta ei voi olla. Se aiheuttaa poikkeuksen ja
				 * se poikkeus saadaan catch-lauseella kiinni. T‰m‰n ansioista
				 * ohjelma ei kaadu vaan jatkaa muiden tunnuksien muuttamista.
				 * 
				 */

				try {
					int oldId = t + 1;
					int newId = t;

					

					String sqlUpdate = "update Pizza set id= ? where id=?";
					PreparedStatement stmtUpdate = conn
							.prepareStatement(sqlUpdate);
					stmtUpdate.setInt(1, newId);
					stmtUpdate.setInt(2, oldId);
					stmtUpdate.executeUpdate();

				}

				catch (Exception e) {
					System.out.println("Edellinen tunnus on jo k‰ytˆss‰!");

					e.printStackTrace();

				}

			}

		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Poisto ei onnistunut");

		}

		finally {
			yhteys.suljeYhteys(conn);
		}

	}

}