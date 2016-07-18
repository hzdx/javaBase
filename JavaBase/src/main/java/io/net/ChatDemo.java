package io.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatDemo {
	public static void main(String[] args) throws Exception {
		DatagramSocket ds1 = new DatagramSocket();
		DatagramSocket ds2 = new DatagramSocket(10003);
		new Thread(new Send(ds1)).start();
		new Thread(new Rece(ds2)).start();
	}
}

class Rece implements Runnable {
	private DatagramSocket ds;

	public Rece(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			while (true) {

				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf, buf.length);

				ds.receive(dp);

				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(), 0, dp.getLength());

				System.out.println(ip + "::" + data);
			}
		} catch (Exception e) {
			throw new RuntimeException("run exception");
		}

	}
}

class Send implements Runnable {
	private DatagramSocket ds;

	public Send(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while ((line = bufr.readLine()) != null) {
				if ("886".equals(line))
					break;
				byte[] buf = line.getBytes();
				DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.183.1"), 10003);
				ds.send(dp);
			}
			ds.close();
		} catch (Exception e) {
			throw new RuntimeException("run exception");
		}

	}
}
