package study.base.collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
class MapTest2
{
	public static void main(String[] args)
	{
		charCount("afalifuqfoqiouroqjorl11");
	}
	public static String charCount(String str)
	{
		char[] chs = str.toCharArray();
		TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();
		for(int x=0;x<chs.length;x++)
		{
			if(!(chs[x]>='a'&&chs[x]<='z' || chs[x]>='A'&&chs[x]<='Z'))
				continue;
			Integer value = tm.get(chs[x]);
			if(value==null)
			{
				tm.put(chs[x],1);
			}
			else
			{
				value=value+1;
				tm.put(chs[x],value);
			}
		}
		Set<Character> keySet = tm.keySet();
		Iterator<Character> it = keySet.iterator();
		while(it.hasNext())
		{
			Character c = it.next();
			int v = tm.get(c);
			System.out.print(c+"("+v+")");
		}
		return null;
	}
}