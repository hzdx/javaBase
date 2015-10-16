package practice.interview.extend;

public class Parrent {
	public Parrent(){
		System.out.println("这是父类 的构造方法！");
	}

	static{
		System.out.println("这是父类的静态代码块！");
	}
	
	{
		System.out.println("这是父类的非静态代码块！");
	}
}
