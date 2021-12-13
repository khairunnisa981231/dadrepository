package exercise4;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;

public class SelectedStationDataOutput{
	
	public static void main(String args[]) throws IOException
	{
		
		String targetFile = "stationBlock.dat";
		
		try
		{
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(targetFile));
			
			
			//station 1 detail
			ByteArrayOutputStream s1Detail = new ByteArrayOutputStream();
			
			s1Detail.write("2421003".getBytes());
			s1Detail.write("Ladang Tebolang Tebong".getBytes());
			s1Detail.write("Alor Gajah".getBytes());
			
			byte s1[] = s1Detail.toByteArray();
			dos.write(s1);
			
			
			//station 2 detail
			ByteArrayOutputStream s2Detail = new ByteArrayOutputStream();
			
			s2Detail.write("2322006".getBytes());
			s2Detail.write("Melaka Pindah".getBytes());
			s2Detail.write("Alor Gajah".getBytes());
			
			byte s2[] = s2Detail.toByteArray();
			dos.write(s2);
			
			
			//6 days rainfall date
			ByteArrayOutputStream bDate = new ByteArrayOutputStream();
			
			bDate.write("23 Oct 2021".getBytes());
			bDate.write("24 Oct 2021".getBytes());
			bDate.write("25 Oct 2021".getBytes());
			bDate.write("26 Oct 2021".getBytes());
			bDate.write("27 Oct 2021".getBytes());
			bDate.write("28 Oct 2021".getBytes());
			
			byte date[] = bDate.toByteArray();
			dos.write(date);
			
			
			//station one rainfall data
			ByteArrayOutputStream s1Data = new ByteArrayOutputStream();
			
			s1Data.write("0.0".getBytes());
			s1Data.write("0.0".getBytes());
			s1Data.write("0.0".getBytes());
			s1Data.write("0.0".getBytes());
			s1Data.write("0.0".getBytes());
			s1Data.write("0.0".getBytes());
			
			byte rainfallOne[] = s1Data.toByteArray();
			dos.write(rainfallOne);
			
			//station one rainfall data
			ByteArrayOutputStream s2Data = new ByteArrayOutputStream();
			
			s2Data.write("0.0".getBytes());
			s2Data.write("0.0".getBytes());
			s2Data.write("1.0".getBytes());
			s2Data.write("1.0".getBytes());
			s2Data.write("0.0".getBytes());
			s2Data.write("1.0".getBytes());
			
			byte rainfallTwo[] = s2Data.toByteArray();
			dos.write(rainfallTwo);
			
			dos.flush();
			dos.close();
		
			
		}
		
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		

		System.out.println("Check out "+targetFile);
	}
	
	
}