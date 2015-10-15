package study.base.exception;

/*
finally
public void method() throws NoException
{
	try
	{
		������ݿ⣻
		��ݲ�����//throw new SQLException()
		�ر���ݿ� //�ö���һ��Ҫִ�С�
	}
	catch(SQLException e)
	{
		�����ݿ�����쳣���?
		throw new NoException 
	}
	finally
	{
		�ر���ݿ� // ������ζ���ִ�У���ʱreturn�˶���ִ�С�
					//ֻ��System.exit(0);�Ų���ִ�С�
	}
}
*/

class FuShuException extends Exception
{
	private String msg;
	FuShuException(String msg)
	{
		this.msg = msg;
	}
	public String getMessage()
	{
		return msg;
	}
}

class De2mo
{
	int div (int a ,int b)	throws FuShuException
	{
		if(b<0)
			throw new FuShuException("����Ϊ��");
		return a/b;
	}
}

class  ExceptionDemo4
{
	public static void main(String[] args) 
	{
		try
		{
			De2mo d = new De2mo();
			int x = d.div(3,-1);
			System.out.println("x="+x);
		}
		catch (FuShuException e)
		{
			System.out.println(e.toString());
			System.out.println("�������쳣��");
			return ;
		}
		finally
		{
			System.out.println("finally over");
		}

		System.out.println("main over");
		
	}
}
