package Socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;


public class MySocket {
	
	public static void main(String[] args) {
		
		if(args.length < 4) 
			new Exception();
			
		String ip = args[0];
		int port = Integer.parseInt(args[1]);
		
		Socket in;
		BufferedReader socketinput;
		PrintStream positiveOutput;
		PrintStream negativOutput;
		
		try {
			in = new Socket(ip, port);
			socketinput = new BufferedReader( new InputStreamReader( in.getInputStream() ) );
			positiveOutput = new PrintStream(new FileOutputStream(args[2]));
			negativOutput = new PrintStream(new FileOutputStream(args[2]));
			
			String text = socketinput.readLine();
			
			if(isPositiv(text))
				positiveOutput.println(text);
			else negativOutput.println(text);

		}catch(SocketException ex){
			System.exit(0);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean isPositiv(String text) {
		// TODO Auto-generated method stub
		return false;
	}
}
