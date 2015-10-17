package study.base.collection;

import java.util.ArrayList;
import java.util.Iterator;

class CollectionDemo {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");
		// 集合的迭代方式1 用迭代器
		for (Iterator it = al.iterator(); it.hasNext();) {
			sop(it.next());
		}
		sop(al.contains("java03"));
		sop(al.isEmpty());
		sop(al);
		// al.remove("java02");
		// al.clear(); //情况全部元素，但不为null
		sop("size:" + al.size());
		ArrayList al1 = new ArrayList();
		al1.add("java03");
		al1.add("java05");
		al.removeAll(al1);// 移除与一个集合重合的元素
		sop(al);
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}