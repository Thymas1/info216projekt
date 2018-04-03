package Semesteroppgave;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Html extends Hent {

	public static void main(String[] args) {
		String content = content.con;
		//String html = "<div><h1> this is test html </h1><p> This is our test paragrapth for our project </p></div>";
		File f = new File("C:\\Users\\thoma\\Desktop\\test.html");

		try {
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		bw.write(content);
		bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
