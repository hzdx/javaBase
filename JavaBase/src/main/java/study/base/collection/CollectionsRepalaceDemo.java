package study.base.collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class CollectionsRepalaceDemo
{
	public static void main(String[] args)
	{
		replaceAll();
	}
	public static void replaceAll()
	{
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");
		sop(list);   //[abcd, aaa, zz, kkkkk]
		Collections.replaceAll(list,"aaa","pp");
		sop(list);  //[abcd, pp, zz, kkkkk]
		Collections.reverse(list);
		sop(list);  //[kkkkk, zz, pp, abcd]
		Collections.fill(list,"cc");
		sop(list);   //[cc, cc, cc, cc]
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}