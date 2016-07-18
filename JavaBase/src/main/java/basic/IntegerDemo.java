package basic;

public class IntegerDemo {
	public static void main(String[] args) {
		// sop("int max:"+Integer.MAX_VALUE);
		// int num = Integer.parseInt("124");// xxx a = XxxparseXxx(String);
		// sop("num="+(num+4));
		sop(Integer.toBinaryString(-6));
		sop(Integer.toHexString(60));
		int x = Integer.parseInt("3c", 16);
		sop("x=" + x);
	}

	public static void sop(String str) {
		System.out.println(str);
	}
}