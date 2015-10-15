package study.base.collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class CollectionsDemo
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
		sop(list);
		//Collections.sort(list,new StrLenComparator());
		Collections.sort(list);
		sop(list);
		String max = Collections.max(list,Collections.reverseOrder(new StrLenComparator()));
		sop(max);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	
}
class StrLenComparator implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		if(s1.length()>s2.length())
			return 1;
		if(s1.length()<s2.length())
			return -1;
		return s1.compareTo(s2);
	}
}