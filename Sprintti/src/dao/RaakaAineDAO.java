package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




import fi.omapizzeria.admin.bean.*;

public class RaakaAineDAO {
private  List<RaakaAine>  selaus, aineet;	







public  List<RaakaAine> tuoRaakaAineet(){
	
	aineet=selaaRaakaAineet();
	
	
	return aineet;
}



	
	public  void luoRaakaaine(String nimi, int saatavuus) {

		ConnectionFactory yhteys = new ConnectionFactory();
		

		Connection conn;

		conn = yhteys.getConnection();
		int id=0;
		
		
		

			
			selaus=selaaRaakaAineet();
			if(selaus.size()>0){
			RaakaAine r=selaus.get(selaus.size()-1);
			 
			id=r.getId()+1;
			 }
			else{
			 id=1;	
		
			}
		
		try {
			
			
			String sqlInsert = "INSERT INTO RaakaAine( nimi, saatavuus, id) VALUES (?, ?, ?)";
			PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
			stmtInsert.setString(1, nimi);
			stmtInsert.setInt(2, saatavuus);
			stmtInsert.setInt(3, id);
			stmtInsert.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Lisäminen ei onnistunut");
		}

		finally {

			yhteys.suljeYhteys(conn);

		}}


	
		
	
	private List<RaakaAine> selaaRaakaAineet(){
		
Connection conn;
		
		ConnectionFactory yhteys = new ConnectionFactory();	
		
		conn = yhteys.getConnection();
		
		selaus=new ArrayList();
		
		try {
			String sql = "select * from RaakaAine";

			Statement aineHaku = conn.createStatement();

			ResultSet aineet = aineHaku.executeQuery(sql);	
			
			
			
			while (aineet.next()) {
				
				
					
				int id = aineet.getInt("id");

				String nimi = aineet.getString("nimi");
				
				int saatavuus=aineet.getInt("saatavuus");
					
				selaus.add(new RaakaAine(id, nimi, saatavuus));
				
			}
			
			
			
		}
		
		catch (Exception e){
		System.out.println("Virhe");	
			
			
			
		}
		
		finally{
			yhteys.suljeYhteys(conn);
		}
				
		
		return selaus;
	}
	
	
	

}
