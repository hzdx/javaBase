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
		sop(list);//[aaa, abcd, kkkkk, qq, z, zz]
		int index = Collections.binarySearch(list,"zz");
		sop("index="+index);//5
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}