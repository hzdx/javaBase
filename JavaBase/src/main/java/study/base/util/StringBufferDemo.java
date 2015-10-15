package study.base.util;
class StringBufferDemo
{
	public static void sop(String str)
	{
		System.out.println(str);
	}
	public static void main(String[] args)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(true).append("abc").append(23);
		sb.insert(4,11);
		sop(sb.toString());
		sb.delete(0,4);
		sop(sb.toString());
		sb.replace(1,2,"b");
		sop(sb.toString());
		sb.setCharAt(2,'b');
		sop(sb.toString());
		sb.reverse();
		sop(sb.toString());
		char[] chs = new char[5];
		sb.getChars(2,6,chs,0);
		for(int x=0;x<chs.length;x++)
		{
			sop("chs["+x+"]="+chs[x]+";");
		}
	}
}
