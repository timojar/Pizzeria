package test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fi.omapizzeria.admin.bean.*;
import dao.*;
import fi.omapizzeria.admin.bean.Pizza;

public class Yhteys {
	
public static void main (String [] args)	{

	
List<Pizza>pizzalista= new ArrayList<Pizza>();

ConnectionFactory yhteys=new ConnectionFactory();
Connection conn;

conn=yhteys.getConnection();

try {

	String sql = "select * from Pizza";

	Statement haku = conn.createStatement();

	ResultSet hakutulokset = haku.executeQuery(sql);

	while (hakutulokset.next()) {

		int id = hakutulokset.getInt("id");

		String nimi = hakutulokset.getString("nimi");

		double hinta = hakutulokset.getDouble("hinta");

		

		
		
		System.out.println(id+" "+nimi+" "+hinta);
	}

} catch (Exception e) {

	e.printStackTrace();

	System.out.println("Tietokantahaku aiheutti virheen");

}



finally{
	
	
	
	
	yhteys.suljeYhteys(conn);
}

	
}
	
	

}
