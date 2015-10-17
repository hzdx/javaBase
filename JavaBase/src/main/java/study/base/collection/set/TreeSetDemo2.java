package study.base.collection.set;

import java.util.Iterator;
import java.util.TreeSet;

class TreeSetDemo2 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add(new NewStu("zhangsan", 17));
		ts.add(new NewStu("lisi", 17));
		ts.add(new NewStu("jack", 18));
		ts.add(new NewStu("tom", 22));
		ts.add(new NewStu("leo", 20));
		ts.add(new NewStu("leo", 20));
		Iterator it = ts.iterator();
		while (it.hasNext()) {
			NewStu stu = (NewStu) it.next();
			System.out.println(stu.getName() + "...." + stu.getAge());
		}
	}
}

class NewStu implements Comparable//
{
	private String name;
	private int age;

	NewStu(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int compareTo(Object obj) {
		// return 0;
		if (!(obj instanceof NewStu))
			throw new RuntimeException("class excetption");
		NewStu s = (NewStu) obj;
		if (this.age > s.age)
			return 1;
		if (this.age == s.age)
			return this.name.compareTo(s.name);
		return -1;

	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}