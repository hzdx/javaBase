package study.base.net.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class TcpClient {
	public static void main(String[] args) throws Exception {
		// �����ͻ��˵�socket����ָ��Ŀ������Ͷ˿�
		Socket s = new Socket("192.168.183.1", 10003);

		// Ϊ�˷�����ݣ�Ӧ��ȡsocket���е��������
		OutputStream out = s.getOutputStream();

		out.write(("tcp ge men lai le").getBytes());

		s.close();
	}
}

/*
 * ���󣺶���˵������ݲ���ӡ�ڿ���̨�ϡ� ����ˣ� 1����������˵�socket����ServerSocket();
 * ������һ���˿ڡ� 2����ȡ���ӹ����Ŀͻ��˶��� ͨ��ServerSocket��
 * accept�����������������������ʽ�ġ�
 * 3���ͻ�����������ݣ���ô�����Ҫʹ�ö�Ӧ�Ŀͻ��˶��󣬲���ȡ��
 * �ͻ��˶���Ķ�ȡ������������ݣ�����ӡ�ڿ���̨�ϡ� 4���رշ���ˣ���ѡ����
 */
class TcpServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10003);

		Socket s = ss.accept();

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "....connected");

		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf, 0, len));

		s.close();
		ss.close();

	}
}
