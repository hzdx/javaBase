package etc;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyText {
	public static void copy() throws IOException {
		FileWriter fw = new FileWriter("RuntimeDemo_copy.txt");
		FileReader fr = new FileReader("RuntimeDemo.java");
		int ch = 0;
		while ((ch = fr.read()) != -1) {
			fw.write(ch);
		}
		fw.close();
		fr.close();
	}

	public static void main(String[] args) throws IOException {
		copy();
	}
}