package study.base.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class BufferedWriterDemo {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("buf.txt");
		BufferedWriter bufw = new BufferedWriter(fw);
		for (int x = 1; x < 5; x++) {
			bufw.write("abcd" + x);
			bufw.newLine();
			bufw.flush();
		}
		bufw.close();
	}
}