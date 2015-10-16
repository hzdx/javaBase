package study.base.io.file;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
class CopyPic
{
	public static void main(String[] args)
	{
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try
		{
			fos = new FileOutputStream("2.jpg");
			fis = new FileInputStream("1.jpg");
			byte[] buf = new byte[1024];
			int len = 0;
			while((len=fis.read(buf))!=-1)
			{
				fos.write(buf,0,len);
			}
		}
		catch(IOException e)
		{
			throw new RuntimeException("复制文件失败");
		}
		finally
		{
			try
			{
				if(fis!=null)
					fis.close();
			}
			catch(IOException e)
			{
				throw new RuntimeException("读取关闭失败");
			}
			try
			{
				if(fos!=null)
					fos.close();
			}
			catch(IOException e)
			{
				throw new RuntimeException("写入关闭失败");
			}
		}
	}
}