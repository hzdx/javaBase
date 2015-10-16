package study.base.exception;

/*
有一个圆形和长方形。
都可以获取面积。如果面积出现非法值，视为获取面积出现问题。

问题通过异常来表示。
现有对这个程序进行基本设计。
*/

class NoValueException extends RuntimeException
{
	NoValueException(String msg)
	{
		super(msg);
	}
}

interface Shape
{
	void getArea();
}

class Rec implements Shape
{
	private int len,wid;
	Rec(int len, int wid)
	{
		if(len <= 0||wid<=0)	
			throw new NoValueException("出现非法值");
		
		
		this.len = len;
		this.wid = wid;
		
	}
	public void getArea()
	{
		System.out.println(len*wid);
	}
}



class ExceptionTest2
{
	public static void main(String[] args) 
	{
		
		try
		{
			Rec r = new Rec(3,-4);
			r.getArea();

		}
		catch (NoValueException e)
		{
			System.out.println(e.toString());
		}
		System.out.println("over");
	}
}
