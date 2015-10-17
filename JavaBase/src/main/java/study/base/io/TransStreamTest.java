package study.base.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class TransStreamTest {
	public static void main(String[] args) throws IOException {
		// InputStream in = System.in;
		// InputStreamReader isr = new InputStreamReader(in);
		// BufferedReader bufr = new BufferedReader(isr);
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		String line = null;
		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line))
				break;
			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}
		bufr.close();
	}
}