package study.base.io.file;

import java.io.FileWriter;
import java.io.IOException;

class FileWriterDemo {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("demo.txt");
		fw.write("abcde");
		// fw.flush();
		fw.close();
	}
}