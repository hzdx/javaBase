package study.base.util;
class StringMethodDemo
{
	public static void method_7()
	{
		String s = "   Hello world";
		sop(s.toLowerCase());
		sop(s.toUpperCase());
		sop(s.trim());
		String s1 = "a1c";
		String s2 = "aaa";
		sop(s1.compareTo(s2));
	}
	public static void main(String[] args)
	{
		method_7();
		method_sub();
		method_split();
		char[] arr = {'a','b','c','d','e','f'};
		String s = new String(arr,1,3);
		sop("s="+s);
		String s1 = "zxcvbnm";
		char[] chs = s1.toCharArray();
		for(int x=0;x<chs.length;x++)
		{
			sop("ch="+chs[x]);
		}
	}
	public static void sop(Object obj)
	{
			System.out.println(obj);
	}
	public static void method_sub()
	{
		String s = "abcdef";
		sop(s.substring(2));
		sop(s.substring(2,4));
	}
	public static void method_split()
	{
		String s = "zhangsan,lisi,wangwu";
		String[] arr = s.split(",");
		for(int x=0;x<arr.length;x++)
		{
			sop(arr[x]);
		}
	}
}

