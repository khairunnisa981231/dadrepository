package parcelmanagementserver.application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import kiosk.parcel.DeliveryInfo;
import kiosk.parcel.DeliveryInfoController;
import kiosk.parcel.ParcelInfo;
import kiosk.parcel.ParcelInfoController;
import parcelmanagementserver.view.ParcelManagementServerFrame;

public class ParcelManagementServerApplication {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		// Display GUI for Parcel Management Server
		ParcelManagementServerFrame frame = new ParcelManagementServerFrame();
				frame.setVisible(true);

				ServerSocket serverSocket = null;

				// Create socket for Parcel Management Server
				int portNo = 4228;
				serverSocket = new ServerSocket(portNo);
				
				frame.updateServerStatus(false);
				
				// wait for connection from client
				Socket kioskSocket = serverSocket.accept();
				
				frame.updateServerStatus(true);
				
				// get list of item product
				DeliveryInfoController deliveryInfoController = new DeliveryInfoController();
				List<DeliveryInfo> deliveryInfo = (List<DeliveryInfo>) deliveryInfoController.getDeliveryInfo();
				
				ObjectOutputStream deliveryOutput = new ObjectOutputStream(kioskSocket.getOutputStream());
				deliveryOutput.writeObject(deliveryInfo);
				
				frame.updateRequestStatus("Receiving Parcel Order Information...");

				//kioskOutputStream.close();
				kioskSocket.close();
			

				while(true)
				{
					//frame.updateServerStatus(false);

					// open the socket to wait for order
					kioskSocket = serverSocket.accept();

					frame.updateServerStatus(true);

					DeliveryInfoController infoDelivery = new DeliveryInfoController();
					ParcelInfoController parcel = new ParcelInfoController();
					
					// get data from client request with object input stream
					
					ObjectInputStream kioskInputStream = new ObjectInputStream(kioskSocket.getInputStream());
					
					String state = (String) kioskInputStream.readObject();
					ParcelInfo infoParcel = (ParcelInfo) kioskInputStream.readObject();
					Double Total = infoDelivery.calcTotal(infoParcel.getWeight(),state);

					// Send total amount to kiosk
					frame.updateRequestStatus("Sending Total Amount to be paid to kiosk");
					ObjectOutputStream kioskOutputStream = new ObjectOutputStream(kioskSocket.getOutputStream());
					kioskOutputStream.writeObject(Total);
					
					DeliveryInfo infoDeliver = (DeliveryInfo) kioskInputStream.readObject();

					//inserting into database
					infoDelivery.insertDeliveryInfo(infoDeliver);
					parcel.insertParcelInfo(infoParcel);

					//double weight = Double.parseDouble(weightStr);
					
					//infoParcel.add();
					frame.updateRequestStatus("Received delivery info");
					
					kioskOutputStream.close();
					kioskSocket.close();
				}
				
			
				}

}
