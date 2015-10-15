package study.base.io;
import java.io.File;
class FileDemo
{
	public static void main(String[] args)
	{
		consMethod();
	}
	public static void consMethod()
	{
		File f1 = new File("a.txt");
		File f2 = new File("c:\\abc","b.txt");
		File d = new File("c:\\abc");
		File f3 = new File(d,"c.txt");
		sop("f1:"+f1);
		sop("f2:"+f2);
		sop("f3:"+f3);
		File f4 = new File("c:"+File.separator+"abc"+File.separator+"zzz"+File.separator+"a.txt");
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}