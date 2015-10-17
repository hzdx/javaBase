package study.base.collection.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

class StuNameComparator implements Comparator<Stu> {
	public int compare(Stu s1, Stu s2) {
		int num = s1.getName().compareTo(s2.getName());
		if (num == 0)
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		return num;
	}
}

class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<Stu, String> tm = new TreeMap<Stu, String>(
				new StuNameComparator());
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