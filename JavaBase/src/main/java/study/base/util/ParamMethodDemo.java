package study.base.util;
class ParamMethodDemo
{
	public static void main(String[] args)
	{
		show("haha",1,4,2,6,9);
	}
	public static void show(String str,int...arr)
	{
		for(int x=0;x<arr.length;x++)
		{
			System.out.println(arr[x]);
		}
	}
}