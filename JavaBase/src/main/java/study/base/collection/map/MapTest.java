package study.base.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Stu implements Comparable<Stu> {
	private String name;
	private int age;

	Stu(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int compareTo(Stu s) {
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if (num == 0)
			return this.name.compareTo(s.name);
		return num;
	}

	public int hashCode() {
		return name.hashCode() + age * 34;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Stu))
			throw new ClassCastException("class cast exception");
		Stu s = (Stu) obj;
		return this.name.equals(s.name) && this.age == s.age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String toString() {
		return name + "..." + age;
	}
}

class MapTest {
	public static void main(String[] args) {
		Map<Stu, String> map = new HashMap<Stu, String>();
		map.put(new Stu("jwi", 21), "Beijing");
		map.put(new Stu("jwi", 21), "xian");
		map.put(new Stu("isjfi", 19), "shanghai");
		map.put(new Stu("wwwi", 22), "london");
		Set<Stu> keySet = map.keySet();
		Iterator<Stu> it = keySet.iterator();
		while (it.hasNext()) {
			Stu s = it.next();

			String addr = map.get(s);
			System.out.println("Student:" + s + "...address:" + addr);
		}
	}
}