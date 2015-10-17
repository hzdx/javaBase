package study.base.net.tcp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class PicClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("192.168.183.1", 10007);
		FileInputStream fis = new FileInputStream("1.bmp");

		OutputStream out = s.getOutputStream();

		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = fis.read(buf)) != -1) {
			out.write(buf, 0, len);
		}

		s.shutdownOutput();

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));
		String str = bufIn.readLine();
		System.out.println(str);

		fis.close();
		s.close();
	}
}

class PicServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10007);
		Socket s = ss.accept();

		FileOutputStream fos = new FileOutputStream("server.bmp");
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = in.read(buf)) != -1) {
			fos.write(buf, 0, len);
		}
		OutputStream out = s.getOutputStream();
		out.write("ͼƬ�ϴ��ɹ�".getBytes());
		fos.close();
		s.close();
		ss.close();
	}
}
