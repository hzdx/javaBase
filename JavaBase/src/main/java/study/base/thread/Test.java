package study.base.thread;

class Test extends Thread
{
	//private String name;
	Test(String name)
	{
		super(name);;
	}
	public void run()
	{
		for(int x=0;x<50;x++)
			System.out.println(Thread.currentThread().getName()+"  test  "+x);
	}
}

class ThreadTest
{
	public static void main(String[] args)
	{
		Test t1 = new Test("A");
		Test t2 = new Test("B");
		t1.start();
		t2.start();
		for(int x=0;x<50;x++)
			System.out.println("hello,world   "+x);
	}
}