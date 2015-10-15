package study.base.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class Read implements Runnable
{
	private PipedInputStream in;
	Read(PipedInputStream in)
	{
		this.in = in;
	}
	public void run()
	{
		try
		{
			byte[] buf = new byte[1024];
			System.out.println("��ȡǰ����û���������");
			int len = in.read(buf);
			System.out.println("������ݣ��������");
			String s = new String(buf,0,len);
			System.out.println(s);
			in.close();
		}
		catch (IOException e)
		{
			throw new RuntimeException("�ܵ�������ʧ��");
		}
	}
}
class Write implements Runnable
{
	private PipedOutputStream out;
	Write(PipedOutputStream out)
	{
		this.out = out;
	}
	public void run()
	{
		try
		{
			System.out.println("��ʼд����ݣ��ȴ�6��");
			Thread.sleep(6000);
			out.write("piped lai la".getBytes());
			out.close();
		}
		catch(Exception e)
		{
			throw new RuntimeException("�ܵ������ʧ��");
		}
	}
}
class PipedStreamDemo
{
	public static void main(String[] args)	throws IOException
	{
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);
		Read r = new Read(in);
		Write w = new Write(out);
		new Thread(r).start();
		new Thread(w).start();
	}
}

