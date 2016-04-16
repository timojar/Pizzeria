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
	
	
	
	public void luoPizzaTayte(String nimi, int pizzaId, List<Tayte>taytelista){
		
		ConnectionFactory yhteys = new ConnectionFactory();
		
		Connection conn;

		conn = yhteys.getConnection();
	
		String sql="INSERT INTO PizzaTayte(tayteNimi, id, nimi) VALUES (? , ?, ?)";
		
		
	try {
		PreparedStatement stmtInsertTayte = conn.prepareStatement(sql);
		for(int i=0; i<taytelista.size(); i++) {
			
			Tayte t= taytelista.get(i);
			System.out.println(pizzaId+" lisays "+ t.getTayteNimi());
			stmtInsertTayte.setString(1, t.getTayteNimi());
			stmtInsertTayte.setInt(2, pizzaId);
			stmtInsertTayte.setString(3, nimi);
			stmtInsertTayte.executeUpdate();

			
			
		}
		
		
		
	} catch (SQLException e) {
		
	}	
	finally {
		yhteys.suljeYhteys(conn);
		
	}
	}
	
	
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

	
	
public void poistaPizzaTaytte(int id){
	
	ConnectionFactory yhteys = new ConnectionFactory();
	

	Connection conn;

	conn = yhteys.getConnection();	
	
	
try {
	
	String sqldelete = "delete from PizzaTayte where id=?";
	PreparedStatement stmtdelete = conn.prepareStatement(sqldelete);
	stmtdelete.setInt(1, id);
	stmtdelete.executeUpdate();
	
	
} catch (SQLException e) {
	
}	

finally{
	yhteys.suljeYhteys(conn);
}

	
}
	

}
