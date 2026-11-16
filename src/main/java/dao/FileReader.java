package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	private static String MY_FILE = "src/main/resources/tondeuse.txt";

	public String read() throws FileNotFoundException {
		File doc = new File(MY_FILE);
		Scanner obj = new Scanner(doc);
		String line = "";
		while (obj.hasNextLine()) {
			line += obj.nextLine();
		}
		obj.close();
		return line;
	}
}
