package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import fi.omapizzeria.admin.bean.*;

public class PizzaDAO {

	private  Pizza pizza;
	private Tayte t;
	private  List<Pizza> pizzalista, selaus;
	
	private int noofPizzas, nextIndex, pizzasperPage, pizzaindex;
	
	
	public List<PizzaTayte>  naytaLopppuvatPizzatTaytteet(boolean  saatavuusyli15){
		

		
		List<PizzaTayte>loppuvatTaytteet=new ArrayList<PizzaTayte>();
	Connection conn;		
	ConnectionFactory yhteys = new ConnectionFactory();	
	conn = yhteys.getConnection();
	
	String sql="select * from Pizza natural join PizzaTayte join Tayte using (tayteId) where saatavuus<15 group by nimi;";	
		
	if(saatavuusyli15==true){
	sql="select * from Pizza natural join Pizzatayte join Tayte using (tayteId) where saatavuus<30;";	
	}
	

	
	
	

	
	try {
		Statement pizzaHaku = conn.createStatement();

		ResultSet pizzat = pizzaHaku.executeQuery(sql);
		
		
	while(pizzat.next()){
		int tayteid=pizzat.getInt("tayteId");
		int pizzaid=pizzat.getInt("id");
		String pizzanimi=pizzat.getString("nimi");
		String tayteNimi=pizzat.getString("tayteNimi");
		loppuvatTaytteet.add(new PizzaTayte ( tayteNimi,  pizzaid, tayteid,  pizzanimi));
	}
		
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	
	
	finally{
		
	}
	
	
	return loppuvatTaytteet;	
	}
	
	
	public Pizza bringPizza(int pizzaId){
		
		
		Connection conn;		
		ConnectionFactory yhteys = new ConnectionFactory();	
		conn = yhteys.getConnection();
		Pizza pizza=null;
		try {
			
			String sql = "select * from Pizza where id = "+pizzaId;
 
			Statement pizzaHaku = conn.createStatement();

			ResultSet pizzat = pizzaHaku.executeQuery(sql);	
			int e=0;
			
			
			while (pizzat.next()) {
				
				int id = pizzat.getInt("id");

				String nimi = pizzat.getString("nimi");

				double hinta = pizzat.getDouble("hinta");
				String kuvaus = pizzat.getString("kuvaus");
				String piiloitus = pizzat.getString("piiloitus");
				
				
			pizza=new Pizza(id, nimi, hinta, kuvaus, piiloitus);
				
				
				
			}
			
			
		}
		
		catch(Exception e){
		e.printStackTrace();	
		}
		
		finally{
			
			yhteys.suljeYhteys(conn);
		}
		
		
		
	return pizza;	
	}
	

	public int haePizzaIndex(int pizzaid){
		Connection conn;		
		ConnectionFactory yhteys = new ConnectionFactory();	
		conn = yhteys.getConnection();
		
		try{
			
			
			String sql = "select * from Pizza";

			Statement pizzaHaku = conn.createStatement();

			ResultSet pizzat = pizzaHaku.executeQuery(sql);	
			int e=0;
			
			
			while (pizzat.next()) {
			e++;	
				
			if(pizzaid==pizzat.getInt("id")) {
			
			pizzaindex=e;	
				
			}
				
			}
				
			
			
			
		}
		
		catch(Exception e){
			
		}
		
		finally{
		yhteys.suljeYhteys(conn);	
		}
		
	
		return pizzaindex;
	};
	
	public void poistaPiiloitus(int paljastaid){
		
Connection conn;		
ConnectionFactory yhteys = new ConnectionFactory();	
String palautus=null;
		
conn = yhteys.getConnection();

	try {
		String hide = "Update Pizza set piiloitus = ? where id = ?";
		
		
		PreparedStatement stmthide = conn.prepareStatement(hide);
		stmthide.setString(1, palautus);
		stmthide.setInt(2, paljastaid);
		stmthide.executeUpdate();

		
		
	}
	
	catch (Exception e) {
	e.printStackTrace();
		System.out.println("Palautus ei onnistunut");	
		
	}
	
	finally {
		yhteys.suljeYhteys(conn);
	}
	
	}
	
		
	
	/**
	 * Pizzan piiloitus: Otetaan Pizzan id vastaan.
	 */	
	
	
	public void piilotaPizza(int piiloitusid){
	
Connection conn;		
ConnectionFactory yhteys = new ConnectionFactory();	
		
conn = yhteys.getConnection();


System.out.println("Nosale");
	try {
		/**
		 * Pizzan piiloitus: Päivitetään se pizza jonka tunnus on sama kuin metodissa saatu sama parametri.
		 * piiloitus-kenttä saa arvon "nosale"
		 */	
		
		
		String hide = "Update Pizza set piiloitus  = 'nosale' where id = ?";
		
		
		PreparedStatement stmthide = conn.prepareStatement(hide);
		stmthide.setInt(1, piiloitusid);
		stmthide.executeUpdate();

		
		
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
				String piiloitus = hakutulokset.getString("piiloitus");
				pizzalista.add(new Pizza(id, nimi, hinta,kuvaus, piiloitus));

			}

		} catch (SQLException e) {

			e.printStackTrace();

			System.out.println("Tietokantahaku aiheutti virheen PizzaDAO:ssa");

		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return pizzalista;
	}

	
	
	
	
	public  int lisaaPizza(String nimi, double hinta, List<Tayte> taytelista) {

		ConnectionFactory yhteys = new ConnectionFactory();
		pizzalista = new ArrayList<Pizza>();
		
		Connection conn;
		Tayte t=taytelista.get(0);
		conn = yhteys.getConnection();
		int id=0;
		String tayte=t.getTayteNimi();
		if(taytelista.size()>1){
		for(int i=1; i<taytelista.size()-1; i++){
			t=taytelista.get(i);
			tayte=tayte+", "+t.getTayteNimi();
		}
		
		t=taytelista.get(taytelista.size()-1);
		tayte=tayte+" ja "+t.getTayteNimi();
		
		}
		
		
		
		try {
			
			selaus=selaaPizzat();
			if(selaus.size()>0){
			Pizza p=selaus.get(selaus.size()-1);
			
			
			 id=p.getId()+1;}
			else{
			 id=1;	
			}
			
			
			String sqlInsert = "INSERT INTO Pizza(id, nimi, hinta, kuvaus, piiloitus) VALUES (?, ?, ?,?, 'nosale')";
			PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
			stmtInsert.setInt(1, id);
			stmtInsert.setString(2, nimi);
			stmtInsert.setDouble(3, hinta);
			stmtInsert.setString(4, tayte);
			stmtInsert.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Lisäminen ei onnistunut");
		}

		finally {

			yhteys.suljeYhteys(conn);

		}
return id;
	}
	

	public void muokkaaPizza(int id, String nimi, double hinta, String kuvaus, List<Tayte> taytelista, boolean check){
		
		ConnectionFactory yhteys = new ConnectionFactory();
	
		
		Connection conn;
		
		conn = yhteys.getConnection();
		
		
		
		if (check==true) {
			
			
			Tayte t=taytelista.get(0);
			
			String tayte=t.getTayteNimi();
			if(taytelista.size()>1){
			
			for(int i=1; i<taytelista.size()-1; i++){
				t=taytelista.get(i);
				tayte=tayte+", "+t.getTayteNimi();
			}
			
			t=taytelista.get(taytelista.size()-1);
			tayte=tayte+" ja "+t.getTayteNimi();
			}	
			kuvaus=tayte;
			
		}
		
		
		
		
		
		
	
	try {
		
String newName = "Update Pizza set nimi = ? where id = ?";
String newPrice = "Update Pizza set hinta  = ?  where id = ?";
String newDesc = "Update Pizza set kuvaus = ?  where id = ?";
		
		PreparedStatement stmName = conn.prepareStatement(newName);
		stmName.setString(1, nimi);
		stmName.setInt(2, id);
		stmName.executeUpdate();

		PreparedStatement stmtPrice = conn.prepareStatement(newPrice);
		stmtPrice.setDouble(1,hinta);
		stmtPrice.setInt(2, id);
		stmtPrice.executeUpdate();

		
		PreparedStatement stmtDesc = conn.prepareStatement(newDesc);
		stmtDesc.setString(1,kuvaus);
		stmtDesc.setInt(2, id);
		stmtDesc.executeUpdate();

		System.out.println(nimi);
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		// TODO: handle exception
	}	
		
	finally {
		yhteys.suljeYhteys(conn);
	}
		
	}
	
	
	public void poistaPizza(int id) {

		ConnectionFactory yhteys = new ConnectionFactory();
		Connection conn;

		conn = yhteys.getConnection();

		
		try {
			

			String sqldelete = "delete from Pizza where id=?";
			PreparedStatement stmtdelete = conn.prepareStatement(sqldelete);
			stmtdelete.setInt(1, id);
			stmtdelete.executeUpdate();

			
			

		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Poisto ei onnistunut");

		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		
	
		
		
	}
	
	private List<Pizza> selaaPizzat(){

		Connection conn;
		
		ConnectionFactory yhteys = new ConnectionFactory();	
		
		conn = yhteys.getConnection();
		
		selaus=new ArrayList();
		
		try {
			String sql = "select * from Pizza";

			Statement pizzaHaku = conn.createStatement();

			ResultSet pizzat = pizzaHaku.executeQuery(sql);	
			
			
			
			while (pizzat.next()) {
				
				
					
				int id = pizzat.getInt("id");

				String nimi = pizzat.getString("nimi");

				double hinta = pizzat.getDouble("hinta");	
				selaus.add(new Pizza(id, nimi, hinta));
				
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