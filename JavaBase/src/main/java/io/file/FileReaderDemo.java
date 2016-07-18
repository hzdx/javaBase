package io.file;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		readWithBuffer();
	}

	public static void read() throws IOException {
		FileReader fr = new FileReader("c:/temp/words.txt");
		int ch = 0;
		while ((ch = fr.read()) != -1) {
			System.out.print((char) ch);
		}
		fr.close();
	}

	public static void readWithBuffer() throws IOException {
		FileReader fr = new FileReader("DateDemo.java");
		char[] buf = new char[1024];
		int num = 0;
		while ((num = fr.read(buf)) != -1) {
			System.out.print(new String(buf, 0, num));
		}
		fr.close();
	}
}