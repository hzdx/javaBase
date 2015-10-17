package study.base.collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class TreeSetTest {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new MyCompare());
		ts.add("avac");
		ts.add("ca");
		ts.add("hhhhhhhhh");
		ts.add("daf");
		ts.add("ha");
		Iterator it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}

class MyCompare implements Comparator {
	public int compare(Object o1, Object o2) {
		String s1 = (String) o1;
		String s2 = (String) o2;
		int num = s1.length() - s2.length();
		if (num == 0)
			return s1.compareTo(s2);
		return num;
	}
}