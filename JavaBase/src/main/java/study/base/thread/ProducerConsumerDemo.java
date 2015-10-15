package study.base.thread;

class ProducerConsumerDemo
{
	public static void main(String [] args)
	{
		Resource r = new Resource();
		Producer p = new Producer(r);
		Consumer c = new Consumer(r);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(c);
		Thread t4 = new Thread(c);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
class Resource
{
	private String name;
	private int cout = 1;
	private boolean flag = false;
	public synchronized void set(String name)
	{
		while(flag)
			try{wait();}catch(Exception e){}
		this.name = name+"--"+cout++;
		System.out.println(Thread.currentThread().getName()+"...[�����]...."+this.name);
		flag = true;
		this.notifyAll();
	}
	public synchronized void out()
	{
		while(!flag)
			try{wait();}catch(Exception e){}
		System.out.println(Thread.currentThread().getName()+"[�����]"+this.name);
		flag = false;	
		this.notifyAll();	
	}
}

class Producer implements Runnable
{
	private Resource r;
	Producer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.set("��Ʒ");
		}
	}
}

class Consumer implements Runnable
{
	private Resource r;
	Consumer(Resource r)
	{
		this.r = r;
	}
	public void run()
	{
		while(true)
		{
			r.out();
		}
	}
}