package study.base.io.file;

import java.io.FileReader;
import java.io.IOException;

class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("c:/temp/words.txt");
		int ch = 0;
		while ((ch = fr.read()) != -1) {
			System.out.print((char) ch);
		}
	}
}