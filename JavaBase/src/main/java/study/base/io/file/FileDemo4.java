package study.base.io.file;
import java.io.File;
class FileDemo4
{
	public static void main(String[] args)
	{
		File dir = new File("d:\\");
		File[] files = dir.listFiles();
		for(File f : files)
		{
			System.out.println(f.getName()+"::"+f.length());
		}
	}
	/*
	public static void method()
	{
		
	}
	*/
	
}