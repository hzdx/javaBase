package study.base.generic;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
class GenericDemo
{
	public static void main(String[] args)
	{
		TreeSet<String> al = new TreeSet<String>(new LenCompare());
		al.add("11e134");
		al.add("eqrqa");
		al.add("sda");
		al.add("11esfafafafa");
		Iterator<String> it = al.iterator();
		while(it.hasNext())
		{
			String s = it.next();
			System.out.println(s+"..."+s.length());
		}
	}
}
class LenCompare implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		int num = s1.length()-s2.length();
		if(num==0)
			return s1.compareTo(s2);
		return num;
	}
}