package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fi.omapizzeria.admin.bean.*;

public class AdminDao {

	private boolean vahvistus;
	private List<Admin> adminit;

	public boolean vahvistaTunnus(String Salasana, String Kayttajanimi) {
		vahvistus = false;
		adminit = new ArrayList<Admin>();
		ConnectionFactory yhteys = new ConnectionFactory();

		Connection conn;

		conn = yhteys.getConnection();
		
		
		try {

			String sql = "select  * from Admin ;";

			Statement haku = conn.createStatement();

			ResultSet hakutulokset = haku.executeQuery(sql);

			while (hakutulokset.next()) {

		

				if (Kayttajanimi.equals(hakutulokset.getString("Kayttajanimi"))
						&& Salasana.equals(hakutulokset.getString("Salasana"))) {
					System.out.println("testi2121 "+Kayttajanimi);

					vahvistus=true;
				}

			}

		}

		catch (SQLException e) {

		}

		finally {
			yhteys.suljeYhteys(conn);
		}

		return vahvistus;
	}

}
