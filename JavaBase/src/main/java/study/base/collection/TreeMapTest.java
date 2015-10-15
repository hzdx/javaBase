package study.base.collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
class StuNameComparator implements Comparator<Student>
{
	public int compare(Student s1,Student s2)
	{
		int num = s1.getName().compareTo(s2.getName());
		if(num==0)
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		return num;
	}
}
class TreeMapTest
{
	public static void main(String[] args)
	{
		TreeMap<Student,String> tm = new TreeMap<Student,String>(new StuNameComparator());
		tm.put(new Student("cjwi",21),"xian");
		tm.put(new Student("asjfi",19),"shanghai");
		tm.put(new Student("bwwi",22),"london");
		tm.put(new Student("cde",22),"changsha");
		tm.put(new Student("cde",22),"jchangsha");
		Set<Student> keySet = tm.keySet();
		Iterator<Student> it = keySet.iterator();
		while(it.hasNext())
		{
			Student s = it.next();
			String addr = tm.get(s);
			System.out.println("Student:"+s+"...address:"+addr);
		}
	}
}