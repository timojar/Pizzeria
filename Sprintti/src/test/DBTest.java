package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBTest {

	public static void main(String[] args) {

		String username = "root";

		String password = "";

		String url = "jdbc:mysql://localhost:3306/tilaus?useSSL=false";

		int id = 2;

		String nimi = "testaus";

		double hinta = 3;

		Connection yhteys = null;

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			yhteys = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {

			e.printStackTrace();

			System.out.println("Ei yhteytt‰");

		}

		try {
			String sqlInsert = "INSERT INTO pizza(id, nimi, hinta) VALUES (?, ?, ?)";
			PreparedStatement stmtInsert = yhteys.prepareStatement(sqlInsert);
			stmtInsert.setInt(1, id);
			stmtInsert.setString(2, nimi);
			stmtInsert.setDouble(3, hinta);
			stmtInsert.executeUpdate();

		}

		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Lis‰minen ei onnistunut");
		}

		finally {

			try {

				if (yhteys != null && !yhteys.isClosed()) {

					yhteys.close();

				}

			}

			catch (Exception e) {

				System.out.println("Tietokantayhteys ei jostain syyst‰ suostu menem‰‰n kiinni.");
			}

		}

	}

}
