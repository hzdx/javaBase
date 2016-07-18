package collection;

import java.util.ArrayList;
/**
 * 将一个ArrayList赋给一个不含重复元素的ArrayList
 */
import java.util.Iterator;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();// 可以包含重复元素
		al.add("java01");
		al.add("java02");
		al.add("java01");
		al.add("java04");
		al.add("java03");
		al.add("java04");
		sop(al);
		// [java01, java02, java01, java04, java03, java04]
		sop(singleElement(al));
		// [java01, java02, java04, java03]
	}

	// 赋给一个不含重复元素的ArrayList
	public static ArrayList singleElement(ArrayList al) {
		ArrayList newAl = new ArrayList();
		Iterator it = al.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (!newAl.contains(obj))
				newAl.add(obj);
		}
		return newAl;
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}