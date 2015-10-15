package study.base.io;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
class PropertiesDemo
{
	public static void main(String[] args)throws IOException
	{
		//loadDemo();
		method_1();
	}
	
	
	public static void loadDemo()throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("info.txt");
		
		//��������ݼ��ؽ�ϡ�
		prop.load(fis);
		
		prop.setProperty("wangwu","40");
		
		FileOutputStream fos = new FileOutputStream("info.txt");
		
		prop.store(fos,"haha");
		//System.out.println(prop);
		prop.list(System.out);
		
		fos.close();
		fis.close();
	}
	
	//��info.txt�м�ֵ��ݴ浽�����н��в�����
	public static void method_1() throws IOException
	{
		BufferedReader bufr = new BufferedReader(new FileReader("info.txt"));
		String line = null;
		Properties prop = new Properties();
		
		while((line=bufr.readLine())!=null)
		{
			String[] arr = line.split("age"); 
			//System.out.println(arr[0]+"..."+arr[1]);
			prop.setProperty(arr[0],arr[1]);
		}
		bufr.close();
		System.out.println(prop);
	
	}
	
	
	
	public  static void setAndGet()
	{
		Properties prop = new Properties();
		prop.setProperty("zhangsan","30");
		prop.setProperty("lisi","39");
		//System.out.println(prop);
		String value = prop.getProperty("lisi");
		//System.out.println(value);
		
		prop.setProperty("lisi","89");
		Set<String> names = prop.stringPropertyNames();
		for(String s : names)
		{
			System.out.println(s+"..."+prop.getProperty(s));
		}
	}
	
	
}