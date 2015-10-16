package study.base.net.tcp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class  TextClient
{
	public static void main(String[] args) throws Exception
	{
		Socket s = new Socket("192.168.183.1",10006);
		BufferedReader bufr = 
			new BufferedReader(new FileReader("IPDemo.java"));


		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			out.println(line);
		}
		
		s.shutdownOutput();

		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = bufIn.readLine();
		System.out.println(str);

		bufr.close();
		s.close();
	}
}

class TextServer
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(10006);
		Socket s = ss.accept();
		
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(new FileWriter("server.txt"),true);
		String line =null;
		while((line=bufIn.readLine())!=null)
		{
			out.println(line);
		}
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		pw.println("�ϴ��ɹ�");
		out.close();
		s.close();
		ss.close();
	}
}
