package parcelmanagementserver.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import kiosk.parcel.DeliveryInfo;
import kiosk.parcel.DeliveryInfoController;

public class ParcelManagementDatabaseController {
	
	private String databaseName = "kioskparcel";
	private String username = "root";
	private String password = "";

	private String connectionPath = "jdbc:mysql://localhost:3306/"+databaseName+"?serverTimezone=GMT%2B8";


	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// get connection object from the database
		Connection connection = DriverManager.getConnection(connectionPath, username, password);

		return connection;
	}
	
}
