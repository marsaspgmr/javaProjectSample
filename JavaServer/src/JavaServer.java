import java.net.*;
import java.io.*;

public class JavaServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		if(args.length != 1){
			System.err.println("Usage: java JavaServer <port number>");
	        System.exit(1);
		}
		
		int portnumber = Integer.parseInt(args[0]);
		
		try{
			serverSocket = new ServerSocket(portnumber);
			System.out.println("Server starting..\n" + "Listening on port: " + Integer.toString(portnumber));
			
		} catch (IOException e){
			e.printStackTrace();
		}
		
		while(true){
			try{
				Socket clientSocket = serverSocket.accept();
				OutputStream clientSocketOutputStream = clientSocket.getOutputStream();
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(clientSocketOutputStream));
				bw.write("Hi client i'm Server!");
				
				System.out.println("Message send to: " + clientSocket.getInetAddress());
				bw.close();
				clientSocket.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
