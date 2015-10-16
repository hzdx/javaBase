package study.base.exception;

/*
特殊的子类异常RuntimeException 运行时异常。
如果在函数内容抛出该异常，函数上可以不用声明；
如果函数上声明了该异常，调用者可以不用进行处理。
之所以不用在函数上声明，是因为不需要让调用者处理。

自定义异常时：如果该异常的发生，无法继续进行运算。
就让自定义异常继承RuntimeException

异常分编译时被检测的异常，不被检测异常（运行时异常，RuntimeException以及子类）。
*/

class ExceptionDemo31
{
	int div (int a ,int b)
	{
		if(b==0)
			throw new RuntimeException("被零除");
		return a/b;
	}
}

class  ExceptionDemo3
{
	public static void main(String[] args) throws MyFuShuException 
	{
		Demo d = new Demo();
		int x = d.div(3,0);
		System.out.println("x="+x);
	}
}
