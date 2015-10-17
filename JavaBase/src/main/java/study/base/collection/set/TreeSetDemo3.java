package study.base.collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class TreeSetDemo3 {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new MyComparator());//
		ts.add(new Student("lisi", 17));
		ts.add(new Student("jack", 18));
		ts.add(new Student("tom", 22));
		ts.add(new Student("leo", 21));
		ts.add(new Student("ceo", 20));
		ts.add(new Student("ceo", 22));
		Iterator it = ts.iterator();
		while (it.hasNext()) {
			Student s = (Student) it.next();
			System.out.println(s.getName() + "....." + s.getAge());
		}
	}
}

class MyComparator implements Comparator {
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		int num = s1.getName().compareTo(s2.getName());
		if (num == 0)
			return s1.getAge() - s2.getAge();// new
												// Integer(s1.getAge()).compareTo(new
												// Integer(s2.getAge()));
		return num;
	}
}

class Student implements Comparable//
{
	private String name;
	private int age;

	Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int compareTo(Object obj) {
		// return 0;
		if (!(obj instanceof Student))
			throw new RuntimeException("class incorrect");
		Student s = (Student) obj;
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