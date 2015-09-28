package Stroeme;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Stroeme {
	
	public static void main(String[] args) {
		//String text = konsoleLesen();
		//konsoleschreiben(text);
		dateiRowLesen();
		dateiRowSchreiben();
		dateiLesen();
		dateiSchreiben();
	}

	private static void dateiRowSchreiben() {
		try {
			BufferedWriter outBuf = new BufferedWriter(new OutputStreamWriter( new FileOutputStream("myoutput.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void dateiRowLesen() {
		try {
			BufferedReader inBuf = new BufferedReader(new InputStreamReader( new FileInputStream("myoutput.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void dateiLesen() {
		
		try {
			BufferedReader inBuf = new BufferedReader(new FileReader("myoutput.chr"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void dateiSchreiben() {
		
		
	}

	private static String konsoleLesen() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private static void konsoleschreiben(String text) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
