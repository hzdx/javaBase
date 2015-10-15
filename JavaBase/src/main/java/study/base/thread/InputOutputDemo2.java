package study.base.thread;

class Res1
{
	private String name;
	private String sex;
	private boolean flag = false;
	public synchronized void set(String name,String sex)
	{
		if(flag)
			try{this.wait();}catch(Exception e){}
		this.name = name;
		this.sex = sex;
		flag = true;
		this.notify();
	}
	public synchronized void out()
	{
		if(!flag)
			try{this.wait();}catch(Exception e){}
		System.out.println(name+"....."+sex);
		flag = false;
		this.notify();
	}
}

class Inp1ut implements Runnable
{
	private Res1 r;
	Inp1ut(Res1 r)
	{
		this.r = r;
	}
	public void run()
	{
		int x = 0;
		while(true)
		{
			if(x==0)
				r.set("mike","man");
			else
				r.set("����","ŮŮŮŮŮ");
			x=(x+1)%2;
		}
	}
}

class Out11put implements Runnable
{
	private Res1 r;
	Out11put(Res1 r)
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

class InputOutputDemo2
{
	public static void main(String[] args)
	{
		Res1 r = new Res1();
		new Thread(new Inp1ut(r)).start();
		new Thread(new Out11put(r)).start();
	}
}