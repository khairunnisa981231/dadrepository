package exercise3;

import java.io.DataOutputStream;
import java.io.FileOutputStream;


public class ChengRainfallInputData 
{
	public static void main(String[] args)
	{
		//output files name
		String file = "ChengRainfallData.txt";
		
		//6 days reading of daily rainfall
		
		String days[] = {"18/10/2021","19/10/2021","20/10/2021","21/10/2021","22/10/2021","23/20/2021"};
		
		double rainfall[] = {-9999.0, -9999.0, 145.0, 0.0, 0.0, 0.0};
		
		try
		{
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
			
			for(int i=0; i<days.length; i++)
			{
				dos.writeUTF(days[i]);
				dos.writeDouble(rainfall[i]);
				
				dos.flush();
			}
			
			dos.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		System.out.println("Check out "+file);
	}

}

