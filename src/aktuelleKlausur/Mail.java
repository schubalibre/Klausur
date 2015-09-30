package aktuelleKlausur;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Mail {
	public void sendMail(String ip, int port, String message) throws IOException{
		Socket socket = new Socket(ip,port);
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		out.println(message);
		socket.close();
	}
}
