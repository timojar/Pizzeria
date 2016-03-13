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

			String sql = "select  * from Pizza ;";
			
			

			Statement haku = conn.createStatement();
				
			ResultSet hakutulokset = haku.executeQuery(sql);

			while (hakutulokset.next()) {

				int id = hakutulokset.getInt("id");

				String nimi = hakutulokset.getString("nimi");

				double hinta = hakutulokset.getDouble("hinta");
				String kuvaus = hakutulokset.getString("kuvaus");
				
				String piilotamerkinta = hakutulokset.getString("poisto");
				
				
			if (piilotamerkinta==null){
				menu.add(new Pizza(id, nimi, hinta,kuvaus));
			}
			}
			
			
			
			for(Pizza p : menu) {
			    System.out.println(p.getNimi());
			    System.out.println(p.getHinta());
			    System.out.println(p.getKuvaus());
			}

		} catch (SQLException e) {

			e.printStackTrace();

			System.out.println("Tietokantahaku aiheutti virheen");

		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return menu;
	}

	
	
	
	
	

}
