package study.base.collection.list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * ListDemo ArrayList指定位置添加，删除元素
 */
class ListDemo {
	public static void sop(Object obj) {
		System.out.println(obj);
	}

	public static void main(String[] args) {
		ArrayList al = new ArrayList();

		al.add("java");
		al.add("c#");
		al.add("jsp");
		sop("list：" + al);
		// java, c#, jsp
		al.add(1, "xml"); // 在下表为1的位置插入"xml"
		// java,xml, c#, jsp
		al.remove(0); // 移除第一个元素
		// xml,c#,jsp
		al.set(0, "sql");
		// ͨsql,c#,jsp.
		sop("get(1): " + al.get(1));
		// c#
		Iterator itr = al.iterator();
		while (itr.hasNext()) {
			sop(itr.next());
		}
	}
}