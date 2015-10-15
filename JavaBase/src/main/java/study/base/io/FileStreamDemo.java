package study.base.io;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
class FileStream
{
	public static void main(String[] args) throws IOException
	{
		WriteFile();
		ReadFile();
	}
	public static void ReadFile() throws IOException
	{
		FileInputStream fis = new FileInputStream("fos.txt");
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=fis.read(buf))!=-1)
		{
			System.out.println(new String(buf,0,len));
		}
		fis.close();
	}
	public static void WriteFile() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("fos.txt");
		fos.write("abcde".getBytes());
	}
}