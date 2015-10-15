package study.base.collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class binarySearchDemo
{
	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");
		list.add("qq");
		list.add("z");
		Collections.sort(list);
		sop(list);
		int index = Collections.binarySearch(list,"zz");
		sop("index="+index);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}