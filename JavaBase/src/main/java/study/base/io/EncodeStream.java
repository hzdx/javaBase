package study.base.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class EncodeStream
{
	public static void main(String[] args) throws IOException
	{
		readText();
	}
	
	public static void readText() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(new FileInputStream("utf.txt"),"gbk");
		char[] buf = new char[10];
		int len = isr.read(buf);
		String str = new String(buf,0,len);
		System.out.println(str);
		isr.close();
	}
	
	public static void writeText()throws IOException
	{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf.txt"),"UTF-8");
		osw.write("���");
		osw.close();
	}
}