package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLHelper {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/cartoonbookdb?characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "root";
	private static Connection con = null;
	
	public static Connection open() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}
}
