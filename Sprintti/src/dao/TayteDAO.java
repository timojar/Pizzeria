package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.admin.bean.*;
/**
 * @Timo Jarmala
 */
public class TayteDAO {

	private  List<Tayte> taytelista, selaus;
	
	
	
	
	
	
	public void muokkaaTayte(String nimi, int maara, int id){
	
		Connection conn;		
		ConnectionFactory yhteys = new ConnectionFactory();	
		conn = yhteys.getConnection();
		String sql="update Tayte set tayteNimi=?, saatavuus=saatavuus+? where tayteId=?;";
		
		try {
			
			
			
			PreparedStatement stmtmuokkaa = conn.prepareStatement(sql);	
			
			
			stmtmuokkaa.setString(1, nimi);
			stmtmuokkaa.setInt(2, maara);
			stmtmuokkaa.setInt(3, id);
			
			stmtmuokkaa.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		finally {
		
			
			
			yhteys.suljeYhteys(conn);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public Tayte tuoTayte(int tayteId){
		
		
		Connection conn;		
		ConnectionFactory yhteys = new ConnectionFactory();	
		conn = yhteys.getConnection();
		Tayte tayte=null;
		try {
			
			String sql = "select * from Tayte where tayteId = "+tayteId;
 
			Statement tayteHaku = conn.createStatement();

			ResultSet taytteet = tayteHaku.executeQuery(sql);	
		
			
			
			while (taytteet.next()) {
				
				int id = taytteet.getInt("tayteId");

				String nimi = taytteet.getString("tayteNimi");

				int saatavuus= taytteet.getInt("saatavuus");
				
				
			tayte=new Tayte(nimi, saatavuus, id );
				
				
				
			}
			
			
		}
		
		catch(Exception e){
		e.printStackTrace();	
		}
		
		finally{
			
			yhteys.suljeYhteys(conn);
		}
		
		
		
	return tayte;	
	}
	
	
	
	
	
	
	
	
	
public void MuokkaaPizzaTayte(String nimi, int pizzaId, List<Tayte>taytelista){
		
		ConnectionFactory yhteys = new ConnectionFactory();
		int id=pizzaId;
		Connection conn;

		conn = yhteys.getConnection();
		
		
		String sql="INSERT INTO Pizzatayte(tayteNimi, id, nimi, tayteId) VALUES (? , ?, ?, ?)";
		String newName = "Update Pizzatayte set nimi = ? where id = ?";
		
	try {
		
		if (nimi!=null) {
			PreparedStatement stmtnewName = conn.prepareStatement(newName);
			stmtnewName.setString(1, nimi);
			stmtnewName.setInt(2, pizzaId);
			stmtnewName.executeUpdate();
		}
		
		if(taytelista.size()>0){
		
			
			String sqldelete = "delete from Pizzatayte where id=?";
			PreparedStatement stmtdelete = conn.prepareStatement(sqldelete);
			stmtdelete.setInt(1, pizzaId);
			stmtdelete.executeUpdate();
			
		}
			
			
		PreparedStatement stmtInsertTayte = conn.prepareStatement(sql);
		for(int i=0; i<taytelista.size(); i++) {
			
			Tayte t= taytelista.get(i);
			System.out.println(pizzaId+" lisays "+ t.getTayteNimi());
			stmtInsertTayte.setString(1, t.getTayteNimi());
			stmtInsertTayte.setInt(2, pizzaId);
			stmtInsertTayte.setString(3, nimi);
			stmtInsertTayte.setInt(4, t.getId());
			stmtInsertTayte.executeUpdate();

			
			
		}
		
		
		
	} catch (SQLException e) {
		
	}	
	finally {
		yhteys.suljeYhteys(conn);
		
	}
	}
	
	
	public void luoPizzaTayte(String nimi, int pizzaId, List<Tayte>taytelista){
		
		ConnectionFactory yhteys = new ConnectionFactory();
		
		Connection conn;

		conn = yhteys.getConnection();
		
		
		String sql="INSERT INTO Pizzatayte(tayteNimi, id, nimi, tayteId) VALUES (? , ?, ?, ?)";
		
		
		try {
			PreparedStatement stmtInsertTayte = conn.prepareStatement(sql);
			for(int i=0; i<taytelista.size(); i++) {
				
				Tayte t= taytelista.get(i);
				
				stmtInsertTayte.setString(1, t.getTayteNimi());
				stmtInsertTayte.setInt(2, pizzaId);
				stmtInsertTayte.setString(3, nimi);
				stmtInsertTayte.setInt(4, t.getId());
				stmtInsertTayte.executeUpdate();

				
				
			}
			
			
		
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	finally {
		yhteys.suljeYhteys(conn);
		
	}
	}
	  
	
	public  void luoTayte(String nimi, int saatavuus) {

		ConnectionFactory yhteys = new ConnectionFactory();
		

		Connection conn;

		conn = yhteys.getConnection();
		
		int id=0;
		
		
		

		
		taytelista=selaaTaytteet();
		System.out.println("Taytteet"+taytelista.size());
		if(taytelista.size()>0){
		Tayte t=taytelista.get(taytelista.size()-1);
		 
		id=t.getId()+1;
		 }
		else{
		 id=1;	
	
		}
		
		
		
		try {
			
			
			String sqlInsert = "INSERT INTO Tayte( tayteNimi, tayteId, saatavuus  ) VALUES (?, ?, ?)";
			PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
			stmtInsert.setString(1, nimi);
			stmtInsert.setInt(2, id);
			stmtInsert.setInt(3, saatavuus);
			
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

			String sql = "select * from Tayte order by tayteNimi ASC;"	                 ;
						
			Statement haku = conn.createStatement();
				
			ResultSet hakutulokset = haku.executeQuery(sql);

			while (hakutulokset.next()) {

				

				String tayteNimi = hakutulokset.getString("tayteNimi");
				int id=hakutulokset.getInt("tayteId");
				int saatavuus=hakutulokset.getInt("saatavuus");
				
				taytelista.add(new Tayte(tayteNimi,saatavuus, id ));

			}

			System.out.println("Taytteet"+taytelista.size());
			
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
	
	String sqldelete = "delete from Pizzatayte where id=?";
	PreparedStatement stmtdelete = conn.prepareStatement(sqldelete);
	stmtdelete.setInt(1, id);
	stmtdelete.executeUpdate();
	
	
} catch (SQLException e) {
	
}	

finally{
	yhteys.suljeYhteys(conn);
}

	
}








public  List<PizzaTayte> haePizzaTaytteet(int pizzaid) 


{
	List<PizzaTayte> taytelista  = new ArrayList<PizzaTayte>();
	ConnectionFactory yhteys = new ConnectionFactory();
	

	Connection conn;

	conn = yhteys.getConnection();

	try {

		String sql = "select * from Pizzatayte where id= ?"	                 ;
					
		PreparedStatement haku= conn.prepareStatement(sql);
			
		haku.setInt(1, pizzaid);
		ResultSet hakutulokset=haku.executeQuery();
		

		while (hakutulokset.next()) {

			

			String tayteNimi = hakutulokset.getString("tayteNimi");
			int tayteid=hakutulokset.getInt("tayteId");
			String pizzanimi=hakutulokset.getString("nimi");
			taytelista.add(new PizzaTayte(tayteNimi, pizzaid,  tayteid,  pizzanimi ));

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



public void maaranVahennys(List<Tayte>kulutetutTaytteet){
ConnectionFactory yhteys = new ConnectionFactory();
Connection conn;
conn = yhteys.getConnection();
String sql="update Tayte set  saatavuus=saatavuus-1 where tayteId=?;";
Tayte t=null;
try {
	
	PreparedStatement stmtmuokkaa = conn.prepareStatement(sql);	
	
	for(int i=0; i<kulutetutTaytteet.size() ;i++){
	t=kulutetutTaytteet.get(i);
	stmtmuokkaa.setInt(1, t.getId());
	
	stmtmuokkaa.executeUpdate();	
	}
	
} catch (SQLException e) {
	e.printStackTrace();
}
finally {
	
	
yhteys.suljeYhteys(conn);	
	
}
	
	
	
}


private List<Tayte>  selaaTaytteet(){
	
	Connection conn;		
	ConnectionFactory yhteys = new ConnectionFactory();	
	conn = yhteys.getConnection();
	taytelista=new ArrayList<Tayte>();
	
	try {

		String sql = "select * from Tayte;"	                 ;
					
		Statement haku = conn.createStatement();
			
		ResultSet hakutulokset = haku.executeQuery(sql);

		while (hakutulokset.next()) {

			

			String tayteNimi = hakutulokset.getString("tayteNimi");
			int id=hakutulokset.getInt("tayteId");
			int saatavuus=hakutulokset.getInt("saatavuus");
			
			taytelista.add(new Tayte(tayteNimi,saatavuus, id ));

		}

		System.out.println("Taytteet"+taytelista.size());
		
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



