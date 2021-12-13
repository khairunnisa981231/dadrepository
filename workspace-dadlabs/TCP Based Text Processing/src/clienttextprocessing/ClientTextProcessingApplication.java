package clienttextprocessing;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTextProcessingApplication {
	
	/**
	 * Run this application from Eclipse.
	 * 
	 * 
	 * @author Nur Khairunnisa Idrus
	 *
	 */
	
	public static void main(String[] args){
	    try{
	        Socket socket = new Socket("localhost",1998);
	        
	        
	        Scanner obj = new Scanner(System.in);
	        System.out.println("Enter text");
	        
	        String text = obj.nextLine();
	        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
	        printWriter.write(text);
	        printWriter.flush();
	        printWriter.close();
	        
	      
	        
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        System.out.println(bufferedReader.readLine());
	        bufferedReader.close();
	        socket.close();
	    }catch(IOException e){}
	}

	    
}
