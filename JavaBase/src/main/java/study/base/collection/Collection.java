package study.base.collection;
import java.util.ArrayList;
import java.util.Iterator;
class CollectionDemo
{
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");
		for(Iterator it = al.iterator();it.hasNext();)
		{
			sop(it.next());
		}
		sop(al.contains("java03"));
		sop(al.isEmpty());
		sop(al);
		//al.remove("java02");
		//al.clear();
		sop("size:"+al.size());
		ArrayList al1 = new ArrayList();
		al1.add("java03");
		al.removeAll(al1);//ȡal��al1�Ľ���:retainAll();
		sop(al);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}