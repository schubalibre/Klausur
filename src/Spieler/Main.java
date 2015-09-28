package Spieler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	
	static ObjectInputStream in;
	static ObjectOutputStream out;
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(Integer.parseInt(args[0]));
			Socket socketIn = server.accept();
			ObjectInputStream in = new ObjectInputStream(socketIn.getInputStream());
					
			Socket socketOut = new Socket(args[1],Integer.parseInt(args[0]));
			out = new ObjectOutputStream(socketOut.getOutputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Spieler spieler;
		try {
			spieler = (Spieler)in.readObject();
			spieler.macheZug();
			out.writeObject(spieler);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
