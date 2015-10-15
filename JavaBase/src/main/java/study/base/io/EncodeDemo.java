package study.base.io;

import java.util.Arrays;
class EncodeDemo
{
	public static void main(String[] args) throws Exception
	{
		String s = "���";
		byte[] b1 = s.getBytes("GBK");
		System.out.println(Arrays.toString(b1));
		String s1= new String(b1,"utf-8");
		System.out.println(s1);
		byte[] b2  = s1.getBytes("utf-8");
		System.out.println(Arrays.toString(b2));
		String s2 = new String(b2,"gbk");
		System.out.println(s2);
		
		
	}
}