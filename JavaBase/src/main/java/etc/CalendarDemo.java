package etc;

import java.util.Calendar;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		// System.out.println(c);
		String[] mons = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		int index = c.get(Calendar.MONTH);
		int index1 = c.get(Calendar.DAY_OF_WEEK);
		sop(c.get(Calendar.YEAR) + "年");
		sop(mons[index]);
		sop(c.get(Calendar.DAY_OF_MONTH) + "日");
		sop(index1);
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}