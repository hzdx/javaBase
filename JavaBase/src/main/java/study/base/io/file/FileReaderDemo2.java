package study.base.io.file;

import java.io.FileReader;
import java.io.IOException;

class FileReaderDemo2 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("DateDemo.java");
		char[] buf = new char[1024];
		int num = 0;
		while ((num = fr.read(buf)) != -1) {
			System.out.print(new String(buf, 0, num));
		}
		fr.close();
	}
}