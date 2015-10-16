package study.base.io.file;
import java.io.FileWriter;
import java.io.IOException;
class FileWriterDemo3
{
	public static void main(String[] args) throws IOException
	{
		FileWriter fw = new FileWriter("demo.txt",true);
		fw.write("hh\r\na");
		fw.close();
	}
}