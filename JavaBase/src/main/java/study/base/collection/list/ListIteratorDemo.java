package study.base.collection.list;
import java.util.ArrayList;
import java.util.ListIterator;
class ListIteratorDemo
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args)
	{
		method();
	}
	public static void method()
	{
		ArrayList al = new ArrayList();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");
		sop(al);
		ListIterator li = al.listIterator();
		while(li.hasNext())
		{
			Object obj = li.next();
			if(obj.equals("java03"))
				li.add("java05");
			if(obj.equals("java04"))
				li.set("java06");
		}
		sop(al);
		while(li.hasPrevious())
		{
			Object obj = li.previous();
			sop("obj= "+obj);
		}
	}
}
