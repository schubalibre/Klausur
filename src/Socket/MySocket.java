package Socket;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;


public class MySocket {
	
	public static void main(String[] args) {
		
		if(args.length < 4) 
			new Exception();
			
		String ip = args[0];
		int port = Integer.parseInt(args[1]);
		
		Socket in = new Socket(ip, port);
		BufferedInputStream socketinput = new BufferedInputStream(in.getInputStream());
		PrintStream positiveOutput = new PrintStream(new FileOutputStream(args[2]));
		PrintStream negativOutput = new PrintStream(new FileOutputStream(args[2]));
		
		try{
		while(true){
			String text = socketinput.readline();
			if(isPositiv(text))
				positiveOutput.println(text);
			else negativOutput.println(text);
			
			}
		}catch(SocketException ex){
			System.exit(0);
		}catch(IOException ex){
		
		}
	}

	private static boolean isPositiv(String text) {
		// TODO Auto-generated method stub
		return false;
	}
}
