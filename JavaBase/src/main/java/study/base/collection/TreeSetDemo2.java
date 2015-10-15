package study.base.collection;
import java.util.Iterator;
import java.util.TreeSet;
class TreeSetDemo2
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet();
		ts.add(new Student("zhangsan",17));
		ts.add(new Student("lisi",17));
		ts.add(new Student("jack",18));
		ts.add(new Student("tom",22));
		ts.add(new Student("leo",20));
		ts.add(new Student("leo",20));
		Iterator it = ts.iterator();
		while(it.hasNext())
		{
			Student stu = (Student)it.next();
			System.out.println(stu.getName()+"...."+stu.getAge());
		}
	}
}

class Student implements Comparable//��ӿ�ǿ����Student�߱��Ƚ���
{
	private String name;
	private int age;
	Student(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public int compareTo(Object obj)
	{
		//return 0;
		if(!(obj instanceof Student))
			throw new RuntimeException("����ѧ�����");
		Student s =(Student)obj;
		if(this.age>s.age)
			return 1;
		if(this.age==s.age)
			return this.name.compareTo(s.name);
		return -1;
		
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
}