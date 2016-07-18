package io.file;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

//LineNumberReader并不能从指定行开始读，只改变getLineNumber返回的行数
public class LineNumberReaderDemo {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("E:\\目录规划.txt");
		LineNumberReader lnr = new LineNumberReader(fr);
		String line = null;
		lnr.setLineNumber(10);
		while ((line = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber() + ":" + line);
		}
		lnr.close();
	}
}