package study.base.collection;

import java.util.Enumeration;
import java.util.Vector;

class VectorDemo {
	public static void main(String[] args) {
		Vector v = new Vector(); // vector是线程安全类
		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");
		Enumeration en = v.elements();
		while (en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
	}
}