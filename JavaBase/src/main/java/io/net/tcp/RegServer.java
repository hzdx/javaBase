package io.net.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class RegServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10009);
		Socket s = ss.accept();

		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) != -1)
			System.out.println(new String(buf, 0, len));

		OutputStream out = s.getOutputStream();
		PrintWriter pw = new PrintWriter(out, true);
		pw.println("<font size=7 color=green>welcome</font>");
		s.close();
		ss.close();
	}
}