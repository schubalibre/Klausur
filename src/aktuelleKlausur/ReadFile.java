package aktuelleKlausur;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
	static public void reverse(String filename) throws FileNotFoundException{
		List<String> dataList = new ArrayList<String>();
		String data;
		FileReader file = new FileReader(filename);
		PrintWriter writer = new PrintWriter(new FileOutputStream(filename));
		
		try{
			BufferedReader br = new BufferedReader(file);
			while ((data = br.readLine()) != null){
				dataList.add(data);
			}
			file.close();
		}catch(IOException e){
			e.printStackTrace();
		}

		for (int i = dataList.size(); i >= 0; i--){
			writer.println(dataList.get(i));
			writer.flush();
		}
		
		writer.close();
	}
}
