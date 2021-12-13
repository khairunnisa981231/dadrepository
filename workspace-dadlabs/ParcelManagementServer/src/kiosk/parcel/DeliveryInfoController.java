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

public class DeliveryInfoController {
	
	public void insertDeliveryInfo(DeliveryInfo deliveryInfo)
	{
		try {
			
			ParcelManagementDatabaseController dbController = new ParcelManagementDatabaseController() ;
			Connection con = dbController.getConnection();

			// initialize query
			String query = "insert into deliveryinfo(senderAddress,receiverAddress,telephoneNo,total)" + " values(?,?,?,?)";

			// create and set prepared statement object
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, deliveryInfo.getSenderAdd());
			statement.setString(2, deliveryInfo.getReceiverAdd());
			statement.setString(3, deliveryInfo.getTelNo());
			statement.setDouble(4, deliveryInfo.getTotal());
			
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
	
	public ArrayList<DeliveryInfo> getDeliveryInfo()
	{
		ArrayList<DeliveryInfo> deliveryInfoList = new ArrayList<DeliveryInfo>();
		try {

			ParcelManagementDatabaseController controller = new ParcelManagementDatabaseController();
			Connection con = controller.getConnection();

			String query = "select * from deliveryinfo";

			PreparedStatement statement = con.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				deliveryInfoList.add(getDeliveryInfoFromResultSet(result));
			}

			return deliveryInfoList;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	private DeliveryInfo getDeliveryInfoFromResultSet(ResultSet result) throws SQLException {
		// TODO Auto-generated method stub
		DeliveryInfo deliveryInfo = new DeliveryInfo();
		deliveryInfo.setSenderAdd(result.getString(1));
		deliveryInfo.setReceiverAdd(result.getString(2));
		deliveryInfo.setTelNo(result.getString(3));	
		deliveryInfo.setTotal(result.getDouble(4));	
		
		return deliveryInfo;
	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	public Double calcTotal(Double weight,String state)
	{
		Double total=0.00;
		
		if(weight>= 0.00 || weight<= 0.50)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 8.00;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 8.50;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 14.85;
			}
			
			
		}
		else if(weight>= 0.51 || weight<= 1.00)
		{
			
			if(state.equals("Within State (Peninsular)"))
			{
				total = 9.00;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 10.05;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 21.20;
			}
			
		}
		else if(weight>=1.01 || weight<= 1.50)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 10.05;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 11.15;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 27.55;
			}
		}
		else if(weight>= 1.51 || weight<= 2.00)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 10.60;
			}
			else if(state.equals("Within Peninsular"))
			{
				total =12.20;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 33.90;
			}
		}
		else if(weight>= 2.01 || weight<= 2.50)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 11.65;
			}
			else if(state.equals("Within Peninsular"))
			{
				total =15.15;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 40.30;
			}
		}
		else if(weight>= 2.51 || weight<= 3.00)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 12.70;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 16.90;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 46.65;
			}
		}
		else if(weight>= 3.01 || weight<= 3.50)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 13.80;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 18.65;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 53.00;
			}
		}
		else if(weight>= 3.51 || weight<= 4.00)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 14.30;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 20.40;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 59.35;
			}
		}
		else if(weight>= 4.01 || weight<=4.50)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 14.85;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 22.15;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 65.70;
			}
		}
		else if(weight>= 4.51 || weight<= 5.00)
		{

			if(state.equals("Within State (Peninsular)"))
			{
				total = 14.85;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 23.30;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 72.10;
			}
		}
		
		else if(weight>= 5.01 || weight<= 5.50)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 15.90;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 24.50;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 78.45;
			}
		}
		else if(weight>= 5.51 || weight<= 6.00)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 15.90;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 25.65;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 84.80;
			}
		}
		else if(weight>=6.01|| weight<= 6.50)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 16.95;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 26.80;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 91.15;
			}
		}
		else if(weight>= 6.51 || weight<= 7.00)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 16.95;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 28.00;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 97.50;
			}
		}
		else if(weight>= 7.01 || weight<= 7.50)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 18.00;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 29.15;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total =103.90;
			}
		}
		else if(weight>= 7.51 || weight<= 8.00)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 18.00;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 30.30;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 110.25;
			}
		}
		else if(weight>= 8.01 || weight<= 8.50)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 20.15;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 31.50;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 116.60;
			}
		}
		else if(weight>= 8.51 || weight<= 9.00)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 20.15;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 32.65;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 122.95;
			}
		}
		else if(weight>= 9.01 || weight<=9.50)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 21.20;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 33.80;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 129.30;
			}
		}
		else if(weight>= 9.51 || weight<= 10.00)
		{
			if(state.equals("Within State (Peninsular)"))
			{
				total = 21.20;
			}
			else if(state.equals("Within Peninsular"))
			{
				total = 35.00;
			}
			else if(state.equals("Sabah & Sarawak"))
			{
				total = 135.70;
			}
		}
		
		return total;
		
	}
	

}
