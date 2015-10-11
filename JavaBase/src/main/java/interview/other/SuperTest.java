package interview.other;

import java.util.Date;

public class SuperTest extends Date {
	private static final long serialVersionUID = 1L;

	private void test() {
		System.out.println(super.getClass().getName());
		//getClass 是Object的方法。
		//这里用 this  super 不加  都可以调用getClass()方法，得到本类的类名。
		// 参考答案输出：interview.other.SuperTest
		System.out.println(super.toString()); //Mon Oct 05 23:01:22 CST 2015 
		System.out.println(super.getDate());
	}

	public static void main(String[] args) {
		new SuperTest().test();
	}
}