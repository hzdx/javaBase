package study.base.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/**
 * 
 * ByteArrayStream
 * 字节数组流
 */
class ByteArrayStream
{
	public static void main(String[] args)
	{
		ByteArrayInputStream bis = new ByteArrayInputStream("AVJLISJ".getBytes());
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int by = 0;
		while((by=bis.read())!=-1)
		{
			bos.write(by);
		}
		System.out.println(bos.size());
		System.out.println(bos.toString());
		
	//  bos.writeTO(new FileOutputStream("a.txt");
	}
	
	
	
}