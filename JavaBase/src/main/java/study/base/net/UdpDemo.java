package study.base.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 ����ͨ��udp���䷽ʽ����һ��������ݷ��ͳ�ȥ��
 ˼·��
 1������udpsocket����
 2���ṩ��ݣ�������ݷ�װ����ݰ��С�
 3��ͨ��socket����ķ��͹��ܣ�����ݰ��ȥ��
 4���ر���Դ��
 */
class UdpSend {
	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(8888);

		byte[] buf = "udp ge men laile".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length,
				InetAddress.getByName("192.168.183.1"), 10000);

		ds.send(dp);

		ds.close();
	}
}

/*
 * ���� ����һ��Ӧ�ó������ڽ���udpЭ�鴫�����ݲ����?
 * 
 * ˼·�� 1������udpsocket����ͨ�������һ���˿ڣ���ʵ���Ǹ��������
 * 2��������ݰ���ΪҪ�洢���յ����ֽ���ݡ� ��Ϊ��ݰ�������и�๦�ܿ�����ȡ�ֽ�����еĲ�ͬ�����Ϣ��
 * 3��ͨ��socket�����receive�������ؾߴ�����ݰ� 4��ͨ����ݰ��������й��ܣ������ȡ����ӡ��
 * 5���ر���Դ��
 */

class UdpRece {
	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(10000);

		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);

			ds.receive(dp);// ����ʽ��ʽ��

			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(), 0, dp.getLength());
			int port = dp.getPort();
			System.out.println(ip + "::" + data + "::" + port);

			// ds.close();
		}
	}
}
