package study.base.exception;

/*
第三种方式
try 
{
    throw new Exception();
}
finally
{
    关资源。
}
catch是用于异常处理，没有catch就必须进行异常声明。

子类在覆盖父类时，如果父类的方法抛出异常，那么子类的覆盖方法，只能抛出父类的异常或者其子类异常。
如果父类抛出多个异常，那么子类在覆盖时，只能抛出父类异常的子集。
如果父类没有异常，子类也不可以抛出异常。
    如果子类发送异常，必须try处理，绝对不能抛。
*/


class  ExceptionDemo5
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
