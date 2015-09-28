package Socket;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class MySocket {
	
	public static void main(String[] args) throws IOException {
		
		if(args.length < 4) 
			new Exception();
			
		String ip = args[0];
		int port = Integer.parseInt(args[1]);

		BufferedReader bf = null;
		PrintStream positiveOutput = null;
		PrintStream negativOutput = null;
		try {
			Socket in = new Socket(ip, port);
			bf = new BufferedReader(new InputStreamReader(in.getInputStream()));
			positiveOutput = new PrintStream(new FileOutputStream(args[2]));
			negativOutput = new PrintStream(new FileOutputStream(args[2]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while(true){
			String text = bf.readLine();
			if(isPositiv(text))
				positiveOutput.println(text);
			else negativOutput.println(text);
			
		}
	}

	private static boolean isPositiv(String text) {
		// TODO Auto-generated method stub
		return false;
	}
}
