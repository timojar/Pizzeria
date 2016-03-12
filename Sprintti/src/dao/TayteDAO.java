package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.admin.bean.*;

public class TayteDAO {

	private  List<Tayte> taytelista;	
	
	public static void luoTayte(String nimi, int saatavuus) {

		ConnectionFactory yhteys = new ConnectionFactory();
		

		Connection conn;

		conn = yhteys.getConnection();

		
		
		
		
		try {
			
			
			String sqlInsert = "INSERT INTO Tayte( tayteNimi, saatavuus) VALUES (?, ?)";
			PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
			stmtInsert.setString(1, nimi);
			stmtInsert.setInt(2, saatavuus);
			
			stmtInsert.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Lisäminen ei onnistunut");
		}

		finally {

			yhteys.suljeYhteys(conn);

		}

	}
	
	
	
public  List<Tayte> haeTaytteet() 
	
	
	{

		ConnectionFactory yhteys = new ConnectionFactory();
		taytelista = new ArrayList<Tayte>();

		Connection conn;

		conn = yhteys.getConnection();

		try {

			String sql = "select * from Tayte"	                 ;
						
			Statement haku = conn.createStatement();
				
			ResultSet hakutulokset = haku.executeQuery(sql);

			while (hakutulokset.next()) {

				int saatavuus = hakutulokset.getInt("saatavuus");

				String tayteNimi = hakutulokset.getString("tayteNimi");

				
				taytelista.add(new Tayte(tayteNimi, saatavuus));

			}

		} catch (SQLException e) {

			e.printStackTrace();

			System.out.println("Tietokantahaku aiheutti virheen");

		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return taytelista;
	}

	
	
	

}
