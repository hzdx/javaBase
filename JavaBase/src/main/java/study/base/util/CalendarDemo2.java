package study.base.util;
import java.util.Calendar;
class CalendarDemo2
{
	public static void main(String[] args)
	{
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH,18);
		printCalendar(c);
	}
	public static void printCalendar(Calendar c)
	{
		
		String[] mons = {"һ��","����","����","����",
						"����","����","����","����",
						"����","ʮ��","ʮһ��","ʮ����"};
		String[] weeks = {"������","����һ","���ڶ�","������","������",
						"������","������"};
		int index = c.get(Calendar.MONTH);
		int index1 = c.get(Calendar.DAY_OF_WEEK);
		sop(c.get(Calendar.YEAR)+"��");
		sop(mons[index]);
		sop(c.get(Calendar.DAY_OF_MONTH)+"��");
		sop(weeks[index1]);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}