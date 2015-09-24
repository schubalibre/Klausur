package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;


public class BinaryNames {
	
	public static void main(String[] args) {
			try {
				
				DataOutputStream out = new DataOutputStream(new FileOutputStream("names.bin"));
				
				out.writeUTF("hallo");

				out.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int num = findeDoppelteNamen("names.bin");
			
			System.out.println("Es waren " + num + " doppelte Namen in der Datei.");
	}
	
	private static int findeDoppelteNamen(String datei){
		// zählt doppelte Namen
		int counter = 0;
		// speichert die Namen 
		HashSet<String> names = new HashSet<String>();
		// liest die Datei binär ein
		DataInputStream in;
		try {
			in = new DataInputStream(new FileInputStream(datei));
			// schaut wie viele Bytes noch übrig sind
			while(in.available() > 0){
				// wenn Name nicht gespeichert werden kann (weil doppelt) zählt der counter eins weiter
				if(!names.add(in.readUTF())){
					counter++;
				}
			}
			in.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		return counter;
	}

}
