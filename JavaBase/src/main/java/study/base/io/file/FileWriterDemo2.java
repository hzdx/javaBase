package study.base.io.file;
import java.io.FileWriter;
import java.io.IOException;
class FileWriterDemo2
{
	public static void main(String[] args)
	{
		FileWriter fw = null;
		try
		{
			fw = new FileWriter("demo.txt");
			fw.write("abacde");
		}
		catch(IOException e)
		{
			System.out.println("catch:"+e.toString());
		}
		finally
		{
			try
			{
				if(fw!=null)
					fw.close();
			}
			catch(IOException e)
			{
				System.out.println(e.toString());
			}
		}
	}
}