package io.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UdpRece {
	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(10000);

		while (true) {
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);

			ds.receive(dp);//

			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(), 0, dp.getLength());
			int port = dp.getPort();
			System.out.println(ip + "::" + data + "::" + port);

			ds.close();
		}
	}
}

class UdpSend {
	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket(8888);

		byte[] buf = "udp ge men laile".getBytes();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.183.1"), 10000);

		ds.send(dp);

		ds.close();
	}
}
