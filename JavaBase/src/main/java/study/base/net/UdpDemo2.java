package study.base.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
class UdpSend2
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds = new DatagramSocket(10002);
		BufferedReader bufr =
			new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			if("886".equals(line))
				break;
			byte[] buf = line.getBytes();
			DatagramPacket dp =
				new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.183.1"),10001);
			ds.send(dp);
		}
		ds.close();
	}
}

class UdpRece2 
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket ds = new DatagramSocket(10001);
		while(true)
		{
			
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);

			ds.receive(dp);//����ʽ��ʽ��
			
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(),0,dp.getLength());
			int port = dp.getPort();
			System.out.println(ip+"::"+data+"::"+port);
		}
	}
}
