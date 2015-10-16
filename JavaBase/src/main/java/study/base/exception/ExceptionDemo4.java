package study.base.exception;

/*
finally
public void method() throws NoException
{
    try
    {
        连接数据库；
        数据操作；//throw new SQLException()
        关闭数据库 //该动作一定要执行。
    }
    catch(SQLException e)
    {
        会对数据库进行异常处理。
        throw new NoException 
    }
    finally
    {
        关闭数据库 // 无论如何都会执行，及时return了都会执行。
                    //只有System.exit(0);才不会执行。
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
			throw new FuShuException("除数为负");
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
			System.out.println("发生负数异常。");
			return ;
		}
		finally
		{
			System.out.println("finally over");
		}

		System.out.println("main over");
		
	}
}
