package io.net.tcp;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(11000);
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress() + " ..connected!");
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) != -1)
			System.out.println(new String(buf, 0, len));

		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		out.println("<font color='red' size='7'>welcome</font>");
		s.close();
		ss.close();
	}
}

/**
 * GET /myweb/demo.html HTTP/1.1 Accept: text/html, application/xhtml+xml,
 * Accept-Language: zh-CN User-Agent: Mozilla/5.0 (compatible; MSIE 10.0;
 * Windows NT 6.1; WOW64; Trident/6 .0; MAAU) Accept-Encoding: gzip, deflate
 * Host: 192.168.183.1:11000 Connection: Keep-Alive
 */
