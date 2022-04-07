package tzc.blog.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private static String url;
	private static String username;
	private static String password;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties properties = new Properties();
		try {
			properties.load(DBUtil.class
					.getResourceAsStream("/jdbc.properties"));
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection()   {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void beginTransaction(Connection conn) throws SQLException {
		if (conn != null) {
			conn.setAutoCommit(false);
		}

	}

	public static void commitTransaction(Connection conn) throws SQLException {
		if (conn != null) {
			conn.commit();
		}
	}

	public static void rollbackTransaction(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
