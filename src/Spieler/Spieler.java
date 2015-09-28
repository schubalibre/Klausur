package Spieler;

import java.io.Serializable;
import java.net.Socket;

public class Spieler implements Serializable{
	
	private Socket socket;
	
	public Spieler(Socket s) {
		socket = s;
	}

	public void macheZug() {
		// TODO Auto-generated method stub
		
	}
}
