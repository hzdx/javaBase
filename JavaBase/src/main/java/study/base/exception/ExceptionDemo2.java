package study.base.exception;

/*
因为项目中会出现特有的问题，未被java所描述并封装对象。
可以对特有问题按照java的思想，进行自定义异常封装。

自定义异常。
需求：在本程序中，对于除数是-1，也视为是错误的，需要对这个问题进行自定义描述。
当在函数内部出现了throw抛出异常现象，那么就必须给出对应的处理动作。
要么在内部 try cacth,要么在函数上声明让调用者处理。

一般函数内出现异常，函数上需要声明。
发现打印结果有异常名称，没有异常的信息，需要定义异常信息。
因为父类中已经把异常信息操作完成了，
所以子类只要在构造时，将异常信息传给super语句。

自定义异常必须是自定义类继承Exception.原因：
异常体系有一个特点：因为异常类和异常对象都需要被抛出。
他们都具备可抛性。这个可抛性是throwable这个体系中的独有特点。
只有这个体系中的类和对象才可以被throws和throw操作。

throws和throw的区别：
1，throws使用在函数上。throw使用在函数内。
2，throws后跟的异常类可以跟多个，用逗号隔开，
throw后跟的是异常对象。

*/

@SuppressWarnings("serial")
class MyFuShuException extends Exception
{
	private String msg;
	//private int value;
	MyFuShuException(String msg) 
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
	int div(int a,int b) throws MyFuShuException
	{
		if(b<0)
			throw new MyFuShuException("除数为负"); //手动通过throw抛出自定义异常现象。
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
		catch (MyFuShuException e)
		{
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			System.out.println("出现负数了");
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
