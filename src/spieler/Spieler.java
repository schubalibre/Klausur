package spieler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Spieler {

	Socket s;
	String name;
	InputStream in;
	OutputStream out;
	
	public Spieler(Socket s, String name) throws IOException {
		this.s = s;
		this.name = name;
		this.in = s.getInputStream();
		this.out = s.getOutputStream();
	}
	
	public void startGame(){
		
	}
	
	public void play(){
		
		while(true){
			
		}
		
	}
	
}
