package spieler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SpielServer {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ServerSocket ss = new ServerSocket(4000);
		Socket s = ss.accept();
		
		Spieler sp = new Spieler(s,"Robert");
		sp.startGame();
		sp.play();
		
	}
}
