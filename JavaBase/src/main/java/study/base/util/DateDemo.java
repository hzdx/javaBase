package study.base.util;
import java.text.SimpleDateFormat;
import java.util.Date;
class DateDemo
{
	public static void main(String[] args)
	{
		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��E hh:mm:ss");
		String time = sdf.format(d);
		System.out.println("time="+time);
		long l = System.currentTimeMillis();
		Date dl = new Date(1);
		System.out.println("dl:"+dl);
	}
}