import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;


//sistemare classi e implementare listerners
public class JavaServer {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Java Server");

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JButton strtButton = new JButton("Start");
		JButton stopButton = new JButton("Stop");

		panel.add(strtButton);
		panel.add(stopButton);

		frame.add(panel);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		if(args.length != 1){
			System.err.println("Usage: java JavaServer <port number>");
	        System.exit(1);
		}
		
		int portnumber = Integer.parseInt(args[0]);
		boolean listening = true;
		
		try(ServerSocket serverSocket = new ServerSocket(portnumber)){
			System.out.println("Server starting..\n" + "Listening on port: " + Integer.toString(portnumber));
			while(listening){
				//call class
				new ServerThread(serverSocket.accept()).start();
			}
		} catch (IOException e){
			e.printStackTrace();
			System.exit(1);
		}
	}
}
