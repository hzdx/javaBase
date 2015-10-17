package study.base.io.file;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

class LineNumberReaderDemo {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("BufferedReaderDemo.java");
		LineNumberReader lnr = new LineNumberReader(fr);
		String line = null;
		lnr.setLineNumber(100);
		while ((line = lnr.readLine()) != null) {
			System.out.println(lnr.getLineNumber() + ":" + line);
		}
		lnr.close();
	}
}