package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseController 
{
	private String db = "lab4";
	private String username = "root";
	private String pass = "";
	
	private String connPath = "jdbc:mysql://localhost:3306/"+db;
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(connPath, username, pass);
		return connection;
	}

}
