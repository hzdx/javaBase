package study.base.io;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
class SystemInfo
{
	public static void main(String[] args) throws IOException
	{
		Properties prop = System.getProperties();
		prop.list(new PrintStream("sysinfo.txt"));
	}
}