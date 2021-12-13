package servertextprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTextProcessingApplication 
{
	public static void main(String[] args){
	    try{
	        ServerSocket serverSocket = new ServerSocket(1998);
	        Socket socket = serverSocket.accept();
	        
	       
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        String clientText = bufferedReader.readLine();
	        int textLength = clientText.length();
	        
	        System.out.println("Received Text: "+clientText);
	        System.out.println("Text Length: "+textLength);
	        
	        
	        bufferedReader.close();

	        socket.close();
	        serverSocket.close();
	    }catch(IOException e){}
	}

}
