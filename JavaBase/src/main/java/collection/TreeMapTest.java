package collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

class IStuNameComparator implements Comparator<Stu> {
	@Override
	public int compare(Stu s1, Stu s2) {
		int num = s1.getName().compareTo(s2.getName());
		if (num == 0)
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		return num;
	}
}

class Stu implements Comparable<Stu> {
	private String name;
	private int age;

	Stu(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Stu s) {
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if (num == 0)
			return this.name.compareTo(s.name);
		return num;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Stu))
			throw new ClassCastException("class cast exception");
		Stu s = (Stu) obj;
		return this.name.equals(s.name) && this.age == s.age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode() + age * 34;
	}

	@Override
	public String toString() {
		return name + "..." + age;
	}
}

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<Stu, String> tm = new TreeMap<Stu, String>(new IStuNameComparator());
		tm.put(new Stu("cjwi", 21), "xian");
		tm.put(new Stu("asjfi", 19), "shanghai");
		tm.put(new Stu("bwwi", 22), "london");
		tm.put(new Stu("cde", 22), "changsha");
		tm.put(new Stu("cde", 22), "jchangsha");
		Set<Stu> keySet = tm.keySet();
		Iterator<Stu> it = keySet.iterator();
		while (it.hasNext()) {
			Stu s = it.next();
			String addr = tm.get(s);
			System.out.println("Student:" + s + "...address:" + addr);
		}
	}
}
