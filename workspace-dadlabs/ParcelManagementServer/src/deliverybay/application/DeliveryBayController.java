package deliverybay.application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import kiosk.parcel.DeliveryInfo;
import kiosk.parcel.DeliveryInfoController;
import deliverybay.view.DeliveryBayFrame;


/**
 * This is the class for DeliveryBay Application Controller
 * This class will display GUI for delivery bay and receive parcel order from parcel management server
 * @author Khairunnisa
 *
 */
public class DeliveryBayController {

	public static void main(String[] args) throws IOException {
		
		//connect to parcel management server
		Socket soc = new Socket("localhost",4228);
		
		
		ObjectInputStream objectInputStream = new ObjectInputStream(soc.getInputStream());
		List<DeliveryInfo> parcelList;
		try {
			parcelList = (List<DeliveryInfo>) objectInputStream.readObject();
			
			DeliveryBayFrame frame = new DeliveryBayFrame();
		    
			Object[] row = new Object[4];
			
			//retrive the parcel order
			for(int i=0; i < parcelList.size(); i++) 
			{
				row[0] = parcelList.get(i).getSenderAdd();
				row[1] = parcelList.get(i).getReceiverAdd();
				row[2] = parcelList.get(i).getTelNo();
				row[3] = parcelList.get(i).getTotal();
			    
				frame.getModel().addRow(row);
			
			}
			
			//display the total of parcel order
			frame.getlblTotal().setText("Total : "+ parcelList.size());
			frame.getTable().setModel(frame.getModel());
			frame.setVisible(true);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}
}
