package study.base.io.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

class SplitFile {
	public static void main(String[] args) throws IOException {
		merge();
	}

	public static void merge() throws IOException {
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for (int x = 1; x <= 5; x++) {
			al.add(new FileInputStream("splitFiles\\" + x + ".part"));
		}

		final Iterator<FileInputStream> it = al.iterator();
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {
			public boolean hasMoreElements() {
				return it.hasNext();
			}

			public FileInputStream nextElement() {
				return it.next();
			}
		};

		SequenceInputStream sis = new SequenceInputStream(en);

		FileOutputStream fos = new FileOutputStream("splitFiles\\6.all");

		byte[] buf = new byte[1024];

		int len = 0;
		while ((len = sis.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}

		fos.close();
		sis.close();
	}

	public static void splitFile() throws IOException {
		FileInputStream fis = new FileInputStream("1.mp3");

		FileOutputStream fos = null;
		byte[] buf = new byte[1024 * 1024];
		int count = 1;
		int len = 0;

		while ((len = fis.read(buf)) != -1) {
			fos = new FileOutputStream("splitFiles\\" + (count++) + ".part");
			fos.write(buf, 0, len);
			fos.close();
		}

		fis.close();
	}
}