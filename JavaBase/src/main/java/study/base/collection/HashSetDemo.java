package study.base.collection;
import java.util.HashSet;
import java.util.Iterator;

class HashSetDemo
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args)
	{
		HashSet hs = new HashSet();
		hs.add("java01");
		sop(hs.add("java02"));
		hs.add("java03");
		sop(hs.add("java02"));
		Iterator it = hs.iterator();
		while(it.hasNext())
		{
			sop(it.next());
		}
	}
}