package study.base.io.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class CopyMp3 {
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		copy();
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "����");
	}

	public static void copy() throws IOException {
		BufferedInputStream bufis = new BufferedInputStream(
				new FileInputStream("1.mp3"));
		BufferedOutputStream bufos = new BufferedOutputStream(
				new FileOutputStream("2.mp3"));
		int by = 0;
		while ((by = bufis.read()) != -1) {
			bufos.write(by);
		}
		bufis.close();
		bufos.close();
	}
}