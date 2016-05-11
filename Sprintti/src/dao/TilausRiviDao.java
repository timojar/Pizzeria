package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		System.out.println(ostoslista.size());
		for(Pizza p : ostoslista){
		PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
		stmtInsert.setInt(1, tilausnumero);
		stmtInsert.setInt(2, p.getId());
		stmtInsert.setInt(3, p.getLkm());
		stmtInsert.setDouble(4, p.getYhteishinta());
		stmtInsert.executeUpdate();
		
		}
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	finally {
		yhteys.suljeYhteys(conn);
	}
}



public List<Tilausrivi> haeRivit(int tilausNro){
	PizzaDAO pizzahallinta=new PizzaDAO();
	List<Tilausrivi>rivit=new ArrayList<Tilausrivi>();
	ResultSet rs=null;
	Connection conn=null;		
	ConnectionFactory yhteys = new ConnectionFactory();
	
	conn = yhteys.getConnection();
	
	String sql="select * from TilausRivi where tilausnumero=?;";
	
	try {
		
		PreparedStatement rowSearch= conn.prepareStatement(sql);
		rowSearch.setInt(1, tilausNro);
	
		rs=rowSearch.executeQuery();
		
		
		
		while(rs.next()){
			
			
			
			int pizzaId=rs.getInt("pizzaid");	
			int lkm=rs.getInt("lkm");
			double hinta=rs.getDouble("hinta");
			
			Pizza pizza=pizzahallinta.bringPizza(pizzaId);
			rivit.add(new Tilausrivi(pizzaId,tilausNro, pizza, lkm, hinta));
		}
		
		
		
		}
		
		
	 catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	finally {
		yhteys.suljeYhteys(conn);
	}
	
	
	
	
	
	return rivit;
	
	
}


public void poistaRiv(int tilausnumero){
	
	Connection conn;
	
	ConnectionFactory yhteys = new ConnectionFactory();	
	
	conn = yhteys.getConnection();
	
	
	
try {
	String sqldelete = "delete from TilausRivi where tilausnumero=?";
	PreparedStatement stmtdelete = conn.prepareStatement(sqldelete);
	stmtdelete.setInt(1, tilausnumero);
	stmtdelete.executeUpdate();
	
	
	
} catch (SQLException e) {
	// TODO: handle exception
	
	e.printStackTrace();
}	
finally {
	
	yhteys.suljeYhteys(conn);
	
	
	
}	
	
	
	
	
	
	
	
}



}
