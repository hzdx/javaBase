package study.base.net.tcp;

/*
 ��ʾTcp�Ĵ���Ŀͻ��˺ͷ���˵Ļ��á�
 ���󣺿ͻ��˸����˷�����ݣ�������յ��󣬸�ͻ��˷�����Ϣ��
 */
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class TcpClient2 {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("192.168.183.1", 10004);
		Thread.sleep(5000);
		OutputStream out = s.getOutputStream();

		out.write("hello,server".getBytes());

		InputStream in = s.getInputStream();

		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf, 0, len));

		s.close();

	}
}

class TcpServer2 {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10004);

		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "...connected");

		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf, 0, len));
		OutputStream out = s.getOutputStream();

		out.write("hello,client".getBytes());
		s.close();
		ss.close();
	}
}
