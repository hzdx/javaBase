package study.base.collection.set;

import java.util.HashSet;
import java.util.Iterator;

class Person {
	private String name;
	private int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int hashCode() {
		// System.out.println(this.name+"...hashCode");
		return name.hashCode() + age * 37;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Person))
			return false;
		Person p = (Person) obj;
		System.out.println(this.name + "..equals.." + p.name);
		return this.name.equals(p.name) && this.age == p.age;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}
}

class HashSetTest {
	public static void sop(Object obj) {
		System.out.println(obj);
	}

	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add(new Person("lisi02", 12));
		hs.add(new Person("lisi01", 11));
		hs.add(new Person("lisi02", 12));
		hs.add(new Person("lisi03", 13));
		Iterator it = hs.iterator();
		while (it.hasNext()) {
			Person p = (Person) it.next();
			sop(p.getName() + "::" + p.getAge()); // 执行了equals方法
		}
		sop(hs.contains(new Person("lisi01", 11))); // true
		hs.remove(new Person("lisi03", 13));
		Iterator itr = hs.iterator();
		while (itr.hasNext()) {
			Person p = (Person) itr.next();
			sop(p.getName() + "::" + p.getAge());
		}
	}
}