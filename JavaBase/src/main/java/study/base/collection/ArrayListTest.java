package study.base.collection;
import java.util.ArrayList;
import java.util.Iterator;
class ArrayListTest
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args)
	{	
		ArrayList al = new ArrayList();
		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java04");
		al.add("java03");
		al.add("java04");
		sop(al);
		sop(singleElement(al));
	}
	public static ArrayList singleElement(ArrayList al)
	{
		ArrayList newAl = new ArrayList();
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			if(!newAl.contains(obj))
				newAl.add(obj);
		}
		return newAl;
	}
}