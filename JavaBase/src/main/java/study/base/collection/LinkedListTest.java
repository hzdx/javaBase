package study.base.collection;
import java.util.LinkedList;
class DuiLie
{
	private LinkedList link;
	DuiLie()
	{
		link = new LinkedList();
	}
	public void myAdd(Object obj)
	{
		link.addFirst(obj);
	}
	public Object myGet()
	{
		return link.removeLast();
	}
	public boolean isNull()
	{
		return link.isEmpty();
	}
}
class LinkedListTest
{
	public static void main(String[] args)
	{
		DuiLie dl = new DuiLie();
		dl.myAdd("java01");
		dl.myAdd("java02");
		dl.myAdd("java03");
		dl.myAdd("java04");
		while(!dl.isNull())
		{
			System.out.println(dl.myGet());
		}
	}
}


