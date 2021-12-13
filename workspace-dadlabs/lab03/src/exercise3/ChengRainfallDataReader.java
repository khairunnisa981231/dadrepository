package exercise3;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class ChengRainfallDataReader {

	public static void main(String[] args) {
		
		String readFile = "ChengRainfallData.txt";
		System.out.println("Reading data from " + readFile + "\n");
		
		try
		{
			DataInputStream dis = new DataInputStream(new FileInputStream(readFile));
			
			double rainfall = 0;
			double totalRainfall = 0;
			int totalRecord = 0;
			String days = "";
			
			
			while (dis.available() >0)
			{
				days = dis.readUTF();
				rainfall = dis.readDouble();
				System.out.println( days + "\t" + rainfall);
				
				totalRainfall += rainfall;
				totalRecord++;
			}
			
			dis.close();
			
			double averageOfRainfall = totalRainfall/totalRecord;
			String formattedAverage = String.format("%.1f", averageOfRainfall);
			System.out.print("\nAverage Rainfall of Cheng (Taman Melaka) for " + totalRecord 
					+ " days: " + formattedAverage + "%");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("\nEnd");

	}

}
