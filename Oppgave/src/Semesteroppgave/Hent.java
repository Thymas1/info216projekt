package Semesteroppgave;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class Hent {
	
	private static HttpURLConnection con;
	
	public static void main(String[] args) throws MalformedURLException,
		ProtocolException, IOException  {
		
		String url = "http://api.openchargemap.io/v2/poi";
		File f = new File("C:\\Users\\thoma\\Desktop\\api.json");
		
		try {
			URL myurl = new URL(url);
			con = (HttpURLConnection) myurl.openConnection();
			
			con.setRequestMethod("GET");
			
			StringBuilder content;
			
			try (BufferedReader in = new BufferedReader(
					
					new InputStreamReader(con.getInputStream()))) {
				
				String line;
				content = new StringBuilder();
				
				while ((line = in.readLine()) != null) {
					content.append(line);
					content.append(System.lineSeparator());
					
				}
			}
			//System.out.println(content.toString());
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.write(content);
				bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} finally {
			con.disconnect();
		}
		
	}
}