package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fi.omapizzeria.admin.bean.*;

public class TilausDao {
	
private List<Tilaus> tilaukset;	
	
public int luoTilaus( int asiakasnumero, String tilausajankohta, String toimitustapa,
		String maksutapa, double yhteishinta){
	int tilausnumero;
	String toimitusajankohta=null;
Timestamp tilausaika=null;
	Connection conn=null;		
	ConnectionFactory yhteys = new ConnectionFactory();
	
	conn = yhteys.getConnection();
	
	
	
	tilaukset=haeTilaukset();
	
		
	if(tilaukset.size()>0){
	Tilaus t=tilaukset.get(tilaukset.size()-1);
	
	
	 tilausnumero=t.getNumero()+1;}
	else{
	 tilausnumero=1;	
	}
	
	try {
		
		String sqlInsert = "insert into Tilaus (tilausnumero, asiakasnumero, tilausajankohta,  toimitustapa, maksutapa, yhteishinta) values(?,?,?,?,?,?);";
		PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
		stmtInsert.setInt(1, tilausnumero);
		stmtInsert.setInt(2, asiakasnumero);
		stmtInsert.setTimestamp(3, tilausaika);
		stmtInsert.setString(4, toimitustapa);
		
		stmtInsert.setString(5, maksutapa);
		stmtInsert.setDouble(6, yhteishinta);
		stmtInsert.executeUpdate();
		
		
		
		
	} catch (SQLException e) {e.printStackTrace();
		// TODO: handle exception
	}
	
	finally{yhteys.suljeYhteys(conn);
		
	}
	return tilausnumero;
	
};
	

public List<Tilaus>	 haeTilaukset(){
	
	
	
	
	Connection conn;
	
	ConnectionFactory yhteys = new ConnectionFactory();	
	
	conn = yhteys.getConnection();
	
	tilaukset=new ArrayList();
	
	try {
		String sql = "select * from Tilaus";

		Statement tilausHaku = conn.createStatement();

		ResultSet orders = tilausHaku.executeQuery(sql);	
		
		
		
		while (orders.next()) {
			
			
				
			int numero = orders.getInt("tilausnumero");

			String tilausajankohta = orders.getString("tilausajankohta");
			
			String toimitusajankohta = ""+orders.getDate("toimitusajankohta");
			String toimitustapa = orders.getString("toimitustapa");
			String maksutapa = orders.getString("maksutapa");
			double yhteishinta = orders.getDouble("yhteishinta");	
			int asiakasnumero=orders.getInt("asiakasnumero");
			tilaukset.add(new Tilaus(asiakasnumero,numero, tilausajankohta,  toimitusajankohta,
					toimitustapa,  maksutapa,yhteishinta));
			
			System.out.println("etunimibytv"+asiakasnumero);
			
			
			
			
		}
		
		
		
	}
	
	catch (SQLException e){
	e.printStackTrace();
		
		
		
	}
	
	finally{
		yhteys.suljeYhteys(conn);
	}
		
	
	System.out.println("Tilaukset "+tilaukset.size());
	
	
	return tilaukset;
	
}
	

}
