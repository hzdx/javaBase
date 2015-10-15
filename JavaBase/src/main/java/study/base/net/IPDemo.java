package study.base.net;

import java.net.InetAddress;
class  IPDemo
{
	public static void main(String[] args) throws Exception
	{
		InetAddress i = InetAddress.getLocalHost();
		//System.out.println(i.toString());
		System.out.println("address:"+i.getHostAddress());
		//System.out.println("name:"+i.getHostName());
	
		//InetAddress ia = InetAddress.getByName("www.baidu.com"); //������ʱ���ܻ�ȡ��
		//System.out.println("address:"+ia.getHostAddress());
		//System.out.println("name:"+ia.getHostName());
	}
}
