package io.net.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class TcpClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("192.168.183.1", 10003);

		OutputStream out = s.getOutputStream();

		out.write(("tcp ge men lai le").getBytes());

		s.close();
	}
}

class TcpServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10003);

		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "....connected");

		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) != -1)
			System.out.println(new String(buf, 0, len));

		s.close();
		ss.close();

	}
}
