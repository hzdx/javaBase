package study.base.collection;
import java.util.ArrayList;
import java.util.Iterator;
class Person
{
	private String name;
	private int age;
	Person(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Person))
			return false;
		Person p = (Person)obj;
		System.out.println(this.name+"...."+p.name);
		return this.name.equals(p.name) && this.age ==p.age;
	}
	public String getName()
	{
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
}
class ArrayListTest2
{
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
	public static void main(String[] args)
	{	
		ArrayList al = new ArrayList();
		al.add(new Person("lisi01",23));
		al.add(new Person("lisi04",24));
		al.add(new Person("lisi03",23));
		al.add(new Person("lisi04",26));
		al.add(new Person("lisi04",24));
		al.add(new Person("lisi01",23));
		/*
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			Person p = (Person)it.next();
			sop(p.getName()+"......"+p.getAge());
		}
		*/
		al = singleElement(al);
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			Person p = (Person)it.next();
			sop(p.getName()+"......"+p.getAge());
		}
		sop("remove lisi04:"+al.remove(new Person("lisi04",26)));
		Iterator itr = al.iterator();
		while(itr.hasNext())
		{
			Person p = (Person)itr.next();
			sop(p.getName()+"......"+p.getAge());
		}
	}
	public static ArrayList singleElement(ArrayList al)
	{
		ArrayList newAl = new ArrayList();
		Iterator it = al.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			if(!newAl.contains(obj))
				newAl.add(obj);
		}
		return newAl;
	}
}
