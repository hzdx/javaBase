package study.base.collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
class Student implements Comparable<Student>
{
	private String name;
	private int age;
	Student(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public int compareTo(Student s)
	{
		int num = new Integer(this.age).compareTo(new Integer(s.age));
		if(num==0)
			return this.name.compareTo(s.name);
		return num;
	}
	public int hashCode()
	{
		return name.hashCode()+age*34;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Student))
			throw new ClassCastException("���Ͳ�ƥ��");
		Student s = (Student)obj;
		return this.name.equals(s.name) && this.age==s.age;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String toString()
	{
		return name+"..."+age;
	}
}
class MapTest
{
	public static void main(String[] args)
	{
		Map<Student,String> map = new HashMap<Student,String>();
		map.put(new Student("jwi",21),"Beijing");
		map.put(new Student("jwi",21),"xian");
		map.put(new Student("isjfi",19),"shanghai");
		map.put(new Student("wwwi",22),"london");
		Set<Student> keySet = map.keySet();
		Iterator<Student> it = keySet.iterator();
		while(it.hasNext())
		{
			Student s = it.next();
			
			String addr = map.get(s);
			System.out.println("Student:"+s+"...address:"+addr);
		}
	}
}