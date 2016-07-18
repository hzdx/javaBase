package oop.initialize;

public class Parrent {
	static {
		System.out.println("这是父类的静态代码块！");
	}

	{
		System.out.println("这是父类的非静态代码块！");
	}

	public Parrent() {
		System.out.println("这是父类 的构造方法！");
	}
}
