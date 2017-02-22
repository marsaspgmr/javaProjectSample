import java.net.*;
import java.io.*;

public class ServerThread extends Thread {
	private Socket socket = null;
	private boolean run = true;

	public ServerThread(Socket socket) {
		super("ServerThread");
		this.socket = socket;
	}
	//devo capire come funziona la comnunicazione
	public void run(){
		try( PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(
	                    new InputStreamReader(
	                        socket.getInputStream()));
			){
			String inputLine;  //inputLine string will be use to read client coordinates
			//send message connection successfull to client
            out.println("Connection estabilished");

            while ((inputLine = in.readLine()) != null) {
           
                if (!run)
                    break;
            }
            socket.close();
		} catch(IOException e){
			e.printStackTrace();
		}
			
			/*old code
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(clientSocketOutputStream));
			bw.write("Connected");
			
			System.out.println("Message send to: " + clientSocket.getInetAddress());
			bw.close();
			clientSocket.close();
		} catch(IOException e){
			e.printStackTrace();*/
		
	}
	
	public boolean stopRun(){
		return false;
	}
}
