package study.base.net.tcp;

/*
 ���󣺽���һ���ı�ת����������
 �ͻ��˸����˷����ı�������˻Ὣ�ı�ת���ɴ�д���ظ�ͻ��ˡ�
 ���ҿͻ��˿��Բ��ϵĽ����ı�ת�������ͻ�������overʱ��ת������
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

class TransClient {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("192.168.183.1", 10005);

		// �����ȡ������ݵ�������
		BufferedReader bufr = new BufferedReader(new InputStreamReader(
				System.in));

		// ����Ŀ�ģ������д��socket�����
		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(
				s.getOutputStream()));

		// ��socket���������д�뻺����
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));

		String line = null;
		while ((line = bufr.readLine()) != null) {
			if ("over".equals(line))
				break;
			bufOut.write(line);
			bufOut.newLine();
			bufOut.flush();

			String str = bufIn.readLine();
			System.out.println("server:" + str);

		}
		bufr.close();
		s.close();

	}
}

class TransServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10005);
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + "...is conneted");

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(
				s.getInputStream()));

		BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(
				s.getOutputStream()));

		String line = null;
		while ((line = bufIn.readLine()) != null) {
			System.out.println(line);

			bufOut.write(line.toUpperCase());
			bufOut.newLine();
			bufOut.flush();
		}
		s.close();
		ss.close();
	}
}

/*
 * �����ӳ��ֵ����� ���󣺿ͻ��˺ͷ���˶���Ī��ĵȴ� Ϊʲô�أ�
 * ��Ϊ�ͻ��˺ͷ���˶�������ʽ��������Щ������û�ж��������ǡ���ô��һֱ�ȡ�
 * ע��ʹ��bufOut.newLine(); bufOut.flush();
 */