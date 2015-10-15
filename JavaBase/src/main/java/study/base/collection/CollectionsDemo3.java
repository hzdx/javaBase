package study.base.collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class CollectionsDemo3
{
	public static void main(String[] args)
	{
		replaceAllDemo();
	}
	public static void replaceAllDemo()
	{
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");
		sop(list);
		Collections.replaceAll(list,"aaa","pp");
		sop(list);
		Collections.reverse(list);
		sop(list);
		Collections.fill(list,"cc");
		sop(list);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}