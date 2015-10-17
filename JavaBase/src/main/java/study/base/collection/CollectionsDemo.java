package study.base.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * CollectionsDemo Collections工具类和Comparator接口
 */
class CollectionsDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abcd");
		list.add("aaa");
		list.add("zz");
		list.add("kkkkk");
		list.add("qq");
		list.add("z");
		sop("list :" + list);
		// Collections.sort(list,new StrLenComparator());
		Collections.sort(list);
		sop("list after sort:" + list); // [aaa, abcd, kkkkk, qq, z, zz]
		Collections.sort(list, new StrLenComparator()); // [z, qq, zz, aaa,
														// abcd, kkkkk]
		sop("list after comparator and sort :" + list);
		String max = Collections.max(list,
				Collections.reverseOrder(new StrLenComparator()));
		sop(max); // z
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

}

/**
 * 
 * StrLenComparator 比较器接口
 */
class StrLenComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		if (s1.length() > s2.length())
			return 1;
		if (s1.length() < s2.length())
			return -1;
		return s1.compareTo(s2);
	}
}