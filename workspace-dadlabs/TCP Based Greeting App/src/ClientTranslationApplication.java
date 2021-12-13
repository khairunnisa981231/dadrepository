import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTranslationApplication {
	
	public static void main(String[] args)
	{
		try
		{
		//connect to server
		Socket socket = new Socket(InetAddress.getLocalHost(),4228);
		
		//create input stream
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		//read from network and display current date
		String text = bufferedReader.readLine();
		System.out.println(text);
		
		//close everything
		bufferedReader.close();
		socket.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
				
	}

}
