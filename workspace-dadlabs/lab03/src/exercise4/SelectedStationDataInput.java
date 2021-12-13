package exercise4;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;


public class SelectedStationDataInput {

	public static void main(String[] args) {
		
		String targetFile = "stationBlock.dat";
		System.out.println("Reading data from " + targetFile + "\n");
		
		try
		{
			DataInputStream dis = new DataInputStream(new FileInputStream(targetFile));
			
			dis.readFully(null);
			
			
			
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("\nEnd");

	}

}
