package kiosk.parcel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import parcelmanagementserver.database.ParcelManagementDatabaseController;

public class ParcelInfoController {
	
	public void insertParcelInfo(ParcelInfo parcelInfo)
	{
		try {
			
			ParcelManagementDatabaseController dbController = new ParcelManagementDatabaseController() ;
			Connection con = dbController.getConnection();

			// initialize query
			String query = "insert into parcelinfo(weight,type,trackingNo)" + " values(?,?,?)";

			// create and set prepared statement object
			PreparedStatement statement = con.prepareStatement(query);
			statement.setDouble(1, parcelInfo.getWeight());
			statement.setString(2, parcelInfo.getType());
			statement.setString(3, parcelInfo.getTrackingNo());

			// execute query
			int i = statement.executeUpdate();
			System.out.println(i + " row inserted");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<ParcelInfo> getParcelInfo()
	{
		ArrayList<ParcelInfo> parcelInfoList = new ArrayList<ParcelInfo>();
		try {

			ParcelManagementDatabaseController controller = new ParcelManagementDatabaseController();
			Connection con = controller.getConnection();

			String query = "select * from parcelinfo";

			PreparedStatement statement = con.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				parcelInfoList.add(getParcelInfoFromResultSet(result));
			}

			return parcelInfoList;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	private ParcelInfo getParcelInfoFromResultSet(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		ParcelInfo parcelInfo = new ParcelInfo();
		parcelInfo.setWeight(result.getDouble(1));
		parcelInfo.setType(result.getString(2));
		parcelInfo.setTrackingNo(result.getString(3));	
		
		return parcelInfo;
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}