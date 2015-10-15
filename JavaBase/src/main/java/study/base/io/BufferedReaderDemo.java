package study.base.io;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class BufferedReaderDemo
{
	public static void main(String[] args) throws IOException
	{
		FileReader fr = new FileReader("buf.txt");
		BufferedReader bufr = new BufferedReader(fr);
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			System.out.println(line);
		}
		bufr.close();
	}
}