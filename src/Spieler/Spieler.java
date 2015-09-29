package Spieler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Spieler{

	public static void main(String[] args) {
		
		int port = Integer.parseInt(args[0]);
		String ip = args[1];
		ObjectInputStream in = null;
		ObjectOutputStream out = null;

		try {
			ServerSocket server = new ServerSocket(port);
			Socket socketIn = server.accept();
			in = new ObjectInputStream(socketIn.getInputStream());		
			Socket socketOut = new Socket(ip,port);
			out = new ObjectOutputStream(socketOut.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		Spielstand spielstand;
		
		try {
			while(true){
				spielstand = (Spielstand)in.readObject();
				spielstand.machZug();
				out.writeObject(spielstand);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
