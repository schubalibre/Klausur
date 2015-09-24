package doubleNames;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class DoubleNames {	
	public void checkUsernames() throws FileNotFoundException{
		String name;
		HashSet<String> names = new HashSet<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new FileOutputStream("duplicates.log"));
		
		try {
			while( (name = br.readLine()) != null){
				if(!names.add(name)){
					writer.println(name);
					writer.flush();
					System.out.println("Doppelter Name in Log Datei geschrieben");
				}	
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {	
		DoubleNames names = new DoubleNames();
		try {
			names.checkUsernames();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
