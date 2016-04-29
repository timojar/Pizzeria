package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.admin.bean.Pizza;

public class MenuDao {
	
	private  Pizza pizza;

	private  List<Pizza> menu;	
	
	
	
public  List<Pizza> haePizzat() 
	
	
	{

		ConnectionFactory yhteys = new ConnectionFactory();
		menu = new ArrayList<Pizza>();

		Connection conn;

		conn = yhteys.getConnection();

		try {
			
			
			
			String sql = "select  * from Pizza order by nimi ASC;";
			
			

			Statement haku = conn.createStatement();
				
			ResultSet hakutulokset = haku.executeQuery(sql);

			while (hakutulokset.next()) {

				/**
				 * Pizzan piiloitus: haetaan kaikki pizzat myös kaikki atribuutit. Varsinkin piiloitus.atribuutti.
				 */				
				int id = hakutulokset.getInt("id");

				String nimi = hakutulokset.getString("nimi");

				double hinta = hakutulokset.getDouble("hinta");
				String kuvaus = hakutulokset.getString("kuvaus");
				String piilotamerkinta = hakutulokset.getString("piiloitus");
				/**
				 * Pizzan piiloitus: Jos piilota kenttä on tyhjä, voidaan lisätä pizza ruokalistalle.
				 */			
				
			if (piilotamerkinta==null){
				menu.add(new Pizza(id, nimi, hinta,kuvaus));
			}
			}
			
			
			
		} catch (SQLException e) {

			e.printStackTrace();

			System.out.println("Tietokantahaku aiheutti virheen MenuDao:ssa");

		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return menu;
	}





	
	
	
	
	

}
