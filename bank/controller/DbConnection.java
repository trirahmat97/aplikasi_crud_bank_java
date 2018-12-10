package bank.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static void main(String[] args) {
		DbConnection obj_DB_Connection = new DbConnection();
		System.out.println(obj_DB_Connection.get_connection());
	}
	
	public Connection get_connection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coba3", "root", "");
		}catch(Exception e) {
			
		}
		return connection;
	}
}
