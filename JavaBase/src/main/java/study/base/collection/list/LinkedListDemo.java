package study.base.collection.list;

import java.util.LinkedList;

/**
 * 
 * LinkedListDemo 使用双向链表实现存储 可以指定在前面插入和 后面插入
 */
class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList link = new LinkedList();

		link.addLast("java01");
		link.addLast("java02");
		// link.add("aa"); //默认等效于 addLast
		link.addLast("java03");
		link.addFirst("java04");
		sop("linkedList:" + link); // linkedList:[java04, java01, java02,
									// java03]
		sop("first:" + link.getFirst()); // first:java04
		sop("last:" + link.getLast());// last:java03
		sop("removeFirst:" + link.removeFirst());// removeFirst:java04
		sop("removeFirstAgin:" + link.removeFirst());// removeFirstAgin:java01
		sop("size:" + link.size());// 2
		while (!link.isEmpty()) {
			sop(link.removeLast()); // 02,03
		}
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}
}
