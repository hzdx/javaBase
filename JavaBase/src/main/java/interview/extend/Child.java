package interview.extend;

public class Child extends Parrent{

	public Child(){
		System.out.println("这是子类的构造方法！");
	}
	static{
		System.out.println("这是子类的静态代码块！");
	}
	
	{
		System.out.println("这是子类的非静态代码块！");
	}
}
