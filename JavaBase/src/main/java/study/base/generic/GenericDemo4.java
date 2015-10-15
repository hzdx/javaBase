package study.base.generic;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import study.base.collection.Student;
class Person
{
	private String name;
	Person(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public String toString()
	{
		return "person:"+name;
	}
}
class Student extends Person
{
	Student(String name)
	{
		super(name);
	}
	public String toString()
	{
		return "student:"+getName();
	}
}
class Worker extends Person
{
	Worker(String name)
	{
		super(name);
	}
	public String toString()
	{
		return "worker:"+getName();
	}
}
class PerComp implements Comparator<Person>
{
	public int compare(Person s1,Person s2)
	{
		return s1.getName().compareTo(s2.getName());
	}
}
class GenericDemo4
{
	public static void main(String[] args)
	{
		TreeSet<Person> ts = new TreeSet<Person>(new StuComp());
		ts.add(new Student("fafadis2"));
		ts.add(new Worker("dds2"));
		ts.add(new Student("ae2"));
		ts.add(new Student("liu"));
		Iterator <Person>it = ts.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
}