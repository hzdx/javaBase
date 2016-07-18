package gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyIE {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("192.168.183.1", 8080);

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("GET /myweb/demo.html HTTP/1.1");
		out.println("Accept:*/*");
		out.println("Accept-Language:zh-cn");
		out.println("Host:192.168.183:11000");
		out.println("connection:closed");
		out.println();
		out.println();

		BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while ((line = bufr.readLine()) != null) {
			System.out.println(line);
		}
		s.close();
	}
}
