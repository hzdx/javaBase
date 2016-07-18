package etc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
		String time = sdf.format(d);
		System.out.println("time=" + time);
		long l = System.currentTimeMillis();
		Date dl = new Date(1);
		System.out.println("dl:" + dl);
	}
}