package fr.imie.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB Utils
 * 
 * @author imie
 * @version 1.0
 */
public class DBUtils {

	private static String url = "jdbc:postgresql://localhost:5432/FIL_ROUGE";
	private static String user = "postgres";
	private static String passwd = "postgres";
	private static Connection conn;

	/**
	 * Connect to database
	 * 
	 * @return connection
	 */
	public static Connection connect_() {

		try {

			conn = DriverManager.getConnection(url, user, passwd);

		} catch (SQLException e) {

			System.out.println("Erreur SQL à la connection.");
			e.printStackTrace();

		}

		return conn;

	}

	/**
	 * Disconnect database
	 */
	public static void disconnect_() {

		if (conn != null) {

			try {

				conn.close();

			} catch (SQLException sqle) {

				System.out
						.println("Erreur SQL à la fermeture de connection : ");

			} catch (Exception e) {

				System.out.println("Erreur à la fermeture de connection : ");
				e.printStackTrace();

			}
		}

	}
}
