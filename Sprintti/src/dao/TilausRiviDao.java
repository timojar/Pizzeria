package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.admin.bean.*;


public class TilausRiviDao {
	
	
	
public void luoTilausRivi(List<Pizza> ostoslista, int tilausnumero){
	
	
	Connection conn=null;		
	ConnectionFactory yhteys = new ConnectionFactory();
	
	conn = yhteys.getConnection();
	
	try {
		
		String sqlInsert = "insert into TilausRivi (tilausnumero, pizzaid, lkm, hinta) values(?,?,?,?);";
		
		for(Pizza p : ostoslista){
		PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
		stmtInsert.setInt(1, tilausnumero);
		stmtInsert.setInt(2, p.getId());
		stmtInsert.setInt(3, p.getLkm());
		stmtInsert.setDouble(4, p.getHinta());
		stmtInsert.executeUpdate();
		
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	finally {
		yhteys.suljeYhteys(conn);
	}
}



public List<Tilausrivi> haeRivit(int TilausNro){
	
	List<Tilausrivi>rivit=new ArrayList<Tilausrivi>();
	ResultSet rs=null;
	Connection conn=null;		
	ConnectionFactory yhteys = new ConnectionFactory();
	
	conn = yhteys.getConnection();
	
	String sql="select * from TilausRivi where id=?;";
	
	try {
		
		PreparedStatement rowSearch= conn.prepareStatement(sql);
		rowSearch.setInt(1, TilausNro);
	
		rs=rowSearch.executeQuery();
		
		
		
		while(rs.next()){
			
			
			
			int PizzaId=rs.getInt("pizzaid");	
			
			rivit.add(new Tilausrivi(PizzaId,TilausNro));
		}
		
		
		
		}
		
		
	 catch (Exception e) {
		// TODO: handle exception
	}
	
	
	finally {
		yhteys.suljeYhteys(conn);
	}
	
	
	
	
	
	return rivit;
	
	
}




}
