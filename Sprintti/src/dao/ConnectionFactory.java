package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	 


	
	
	
	
	
	public static Connection getConnection() {
		
	
		Connection conn = null;
		String username = "a1500863";

		String password = "kiHIwZ57b";
		String url = "jdbc:mysql://localhost:3306/a1500863";

		
		try {

			Class.forName("org.mariadb.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {

			e.printStackTrace();

			System.out.println("Ei yhteytt‰");

		}

return conn;		
		
	}

	
	
	
	
	
	public static void suljeYhteys(Connection conn) {

		try {

			if (conn != null && !conn.isClosed()) {

				conn.close();

			}

		}

		catch (Exception e) {

			System.out
					.println("Tietokantayhteys ei jostain syyst‰ suostu menem‰‰n kiinni.");
		}

	}

}
