package basic;

import oop.User;

public class IncTest {

	// 传值，只是把指针拷贝
	public static void convert(int i) {
		i = 5;
	}

	public static void convertStr(String str) {
		str = new String("def");
	}

	public static void convertUser(User str) {
		// str = new User(2, "def");
		str.setName("def");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		// i = 5;
		convert(i);
		System.out.println(i);

		String s = "abc";
		// s = "def";
		convertStr(s); // 用方法改变变量没用？？
		System.out.println(s);

		User user = new User(1, "aaa");
		convertUser(user);
		System.out.println(user);

		String str = "123";
		String str2 = str.replace("1", "aaa");
		System.out.println(str + " \t " + str2);
	}
}
