package start;

import java.io.FileNotFoundException;

import dao.FileReader;

public class ReadFile {

	public static void main(String[] args) {
		FileReader reader = new FileReader();
		try {
			System.out.println(reader.read());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
