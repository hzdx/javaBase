package study.base.exception;

/*


*/

class FuShuException extends Exception
{
	private String msg;
	//private int value;
	FuShuException(String msg) 
	{
		super(msg);
	}
	//this.value = value;
	public String getMessage()
	{
		return msg;
	}
}



class Demo
{
	int div(int a,int b) throws FuShuException
	{
		if(b<0)
			throw new FuShuException("锟斤拷锟斤拷为锟斤拷"); //锟街讹拷通锟斤拷throw锟阶筹拷锟皆讹拷锟斤拷锟届常锟斤拷锟斤拷
		return a/b;
	}
}

class  ExceptionDemo2
{
	public static void main(String[] args) 
	{
		Demo d = new Demo();
		try
		{
			int x = d.div(4,-2);
			System.out.println("x="+x);
		}
		catch (FuShuException e)
		{
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			System.out.println("锟斤拷锟街革拷锟斤拷锟斤拷");
		}
		System.out.println("over");
	}
}

/*
class Throwable
{
	private String message;
	Throwable(String message)
	{
		this.message = message;
	}
	public String getMessage()
	{
		return message;	
	}

}

class Exception extends Throwable
{
	Exception(String message)
	{
		super(message);
	}
}
*/
