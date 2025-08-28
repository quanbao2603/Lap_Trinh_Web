package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			String url = "jdbc:mysql://localhost:3306/womtechshop";
			String username = "root";
			String password = "1234";
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null && !c.isClosed()) {
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}