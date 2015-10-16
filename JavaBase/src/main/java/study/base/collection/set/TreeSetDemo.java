package study.base.collection.set;
import java.util.Iterator;
import java.util.TreeSet;
class TreeSetDemo
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet();
		ts.add("abc");
		ts.add("bc");
		ts.add("aaa");
		ts.add("ae");
		Iterator it = ts.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}