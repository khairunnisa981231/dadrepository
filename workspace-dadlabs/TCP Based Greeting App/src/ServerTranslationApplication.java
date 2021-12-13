import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTranslationApplication 
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket serverSocket = null;
		
		try
		{
			//bind Serversocket to a port
			int portNo = 4228;
			serverSocket = new ServerSocket(portNo);
			
			String text1 = "Good Afternoon";
			System.out.println("Waiting for request");
			
			while(true)
			{
				//Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				//create stream to write data on the network
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
				
				//send current data back to the client
				outputStream.writeUTF(text1);
				
				//close socket
				clientSocket.close();
			}
			
		}
		catch (IOException e)
		{
			if (serverSocket !=null)
				serverSocket.close();
			
			e.printStackTrace();
		}
		
	}
}
