package study.base.io;
import java.io.InputStream;
class MyBufferedInputStream
{
	private InputStream in;
	private byte[] buf = new byte[1024];
	private int pos = 0,count = 0;
	MyBufferedInputStream(InputStream in)
	{
		this.in = in;
	}
	public int myRead()
	{
		if(count==0)
		{
			count = in.read(buf);
			if(count<0)
				return -1;
			pos = 0;
			byte b = buf[pos];
			count--;
			pos++;
			return b;
		}
		else if(count>0)
		{
			byte b = buf[pos];
			count--;
			pos++;
			return b;
		}
		return -1;
	}
	public void myClose()
	{
		in.close();
	}
}
